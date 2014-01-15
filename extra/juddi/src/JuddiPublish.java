package juddi;

import org.uddi.api_v3.*;
import org.uddi.v3_service.*;
import org.apache.juddi.v3.client.transport.Transport;
import org.apache.juddi.v3_service.JUDDIApiPortType;
import org.apache.juddi.api_v3.*;
import org.apache.juddi.v3.client.*;
import org.apache.juddi.v3.client.config.*;

public class JuddiPublish {

  public static void main(String[] args) {
    JuddiProperties juddiProps=new JuddiProperties();
    juddiProps.setAuthorizedName("AuthorisedName");
    juddiProps.setPublisherName("MyPublisher");
    juddiProps.setBusinessName("MyBusinessMetro");
    //juddiProps.setBusinessName("MyBusinessAxis");
    juddiProps.setServiceName("CmmdcWSService");
    //juddiProps.setServiceName("CmmdcService");
    juddiProps.setServiceLang("RO");
    juddiProps.setServiceDesc("Calculul celui mai mic divizor comun a doua numere");
    juddiProps.setServiceKeyWord("cmmdc");
    juddiProps.setWsdlURL("http://localhost:8080/jaxws-cmmdc/cmmdcws?wsdl");
    //juddiProps.setWsdlURL("http://localhost:8080/axis2/services/CmmdcWSService?wsdl");
    juddiProps.setAccessPointType("wsdlDeployment");
    
    JuddiUtil juddiUtil=new JuddiUtil();
    JuddiElems juddiElems=juddiUtil.init();
    if(juddiElems!=null){
       publish(juddiProps,juddiElems);
    }
    System.out.println("Sfarsit");
  }
  
  public static void publish(JuddiProperties juddiProps, JuddiElems juddiElems){
    String authorizedName=juddiProps.getAuthorizedName();
    String publisherName=juddiProps.getPublisherName();
    String businessName=juddiProps.getBusinessName();
    String serviceName=juddiProps.getServiceName();
    String serviceLang=juddiProps.getServiceLang();
    String serviceDesc=juddiProps.getServiceDesc();
    String wsdlURL=juddiProps.getWsdlURL();
    String accessPointType=juddiProps.getAccessPointType();
    String serviceKeyWord=juddiProps.getServiceKeyWord();
    
    UDDISecurityPortType securityPortType=juddiElems.getSecurityPortType();
    JUDDIApiPortType apiPortType=juddiElems.getApiPortType();
    UDDIPublicationPortType publicationPortType=juddiElems.getPublicationPortType();
    UDDIInquiryPortType inquiryPortType=juddiElems.getInquiryPortType();
    org.uddi.api_v3.AuthToken rootAuthToken=juddiElems.getRootAuthToken();

    try{
   // Fixarea datelor de autentificare a autorului celui care dispune
   // publicarea, stergerea inregistrarilor in BD jUDDI
      GetAuthToken getAuthTokenMyPub = new GetAuthToken();
      getAuthTokenMyPub.setUserID(authorizedName);
      getAuthTokenMyPub.setCred("");
      org.uddi.api_v3.AuthToken myPubAuthToken = securityPortType.getAuthToken(getAuthTokenMyPub);
      System.out.println ("myPub AUTHTOKEN = " + myPubAuthToken.getAuthInfo());
      
   // Crearea unui "publisher"
      Publisher p = new Publisher();
      p.setAuthorizedName(authorizedName);
      p.setPublisherName(publisherName);

   // Crearea unui "SavePublisher" Se utilizeaza autentificarea data de 'root'
      SavePublisher sp = new SavePublisher();
      sp.getPublisher().add(p);
      sp.setAuthInfo(rootAuthToken.getAuthInfo());
      apiPortType.savePublisher(sp);

   // Crearea unui obiect "BusinessEntity"
      BusinessEntity myBusEntity = new BusinessEntity();
      Name myBusName = new Name();
      myBusName.setValue(businessName);
      myBusEntity.getName().add(myBusName);    

   // Crearea unui "SaveBusiness" Se utilizeaza autentificarea data cel care publica
      SaveBusiness sb = new SaveBusiness();
      sb.getBusinessEntity().add(myBusEntity);
      sb.setAuthInfo(myPubAuthToken.getAuthInfo());
      BusinessDetail bd = publicationPortType.saveBusiness(sb);
      String myBusKey = bd.getBusinessEntity().get(0).getBusinessKey();
      System.out.println(businessName+" key:  " + myBusKey);

   // Crearea unui obiect de tip BusinessService
      BusinessService businessService = new BusinessService();  
      businessService.setBusinessKey(myBusKey);
      Name myServName = new Name();
      myServName.setValue(serviceName);
      myServName.setLang(serviceLang);
      businessService.getName().add(myServName);
    
   // atasarea unei descrieri 
      Description serviceDescription=new Description();     
      serviceDescription.setLang(serviceLang);
      serviceDescription.setValue(serviceDesc);
      businessService.getDescription().add(serviceDescription);

   // atasarea unui sablon
      BindingTemplates templates=new BindingTemplates();
      BindingTemplate bindingTemplate=new BindingTemplate();
      bindingTemplate.getDescription().add(serviceDescription);
            
   // atasarea punctului la acces al serviciului Web
      AccessPoint accessPoint=new AccessPoint();
      accessPoint.setUseType(accessPointType);
      accessPoint.setValue(wsdlURL);
      bindingTemplate.setAccessPoint(accessPoint);
      templates.getBindingTemplate().add(bindingTemplate); 
      businessService.setBindingTemplates(templates);

   // Crearea unui obiect "SaveService"
      SaveService ss = new SaveService();
      ss.getBusinessService().add(businessService);
      ss.setAuthInfo(myPubAuthToken.getAuthInfo());
      ServiceDetail sd = publicationPortType.saveService(ss);
      String myServKey = sd.getBusinessService().get(0).getServiceKey();
      System.out.println("myServKey:  " + myServKey);
    
      bindingTemplate.setServiceKey(myServKey);
   // Crearea unui obiect "SavaBinding"   
      SaveBinding saveBinding=new SaveBinding();
      saveBinding.setAuthInfo(myPubAuthToken.getAuthInfo()); 
      saveBinding.getBindingTemplate().add(bindingTemplate);   
      BindingDetail bindingDetail=publicationPortType.saveBinding(saveBinding);     
      System.out.println("Binding key: "+
        bindingDetail.getBindingTemplate().get(0).getBindingKey());
    
   //  Fixarea detaliului atasat serviciului Web
      GetServiceDetail serviceDetail=new GetServiceDetail();   
      serviceDetail.getServiceKey().add(myServKey);   
      serviceDetail.setAuthInfo(myPubAuthToken.getAuthInfo());    
      ServiceDetail details = inquiryPortType.getServiceDetail(serviceDetail);     
      System.out.println("Published service name: "+
        details.getBusinessService().get(0).getName().get(0).getValue());
    } 
    catch (Exception e) {
      System.out.println(
        "\n----------------------------------------------------------------");
      System.out.println(
        "A aparut o eroare :" + e.getMessage()+
        "\n----------------------------------------------------------------\n");
      e.printStackTrace();
    }     
  }
}
