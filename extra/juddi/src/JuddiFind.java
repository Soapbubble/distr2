package juddi;

import org.uddi.api_v3.*;
import org.uddi.v3_service.*;
import org.apache.juddi.v3.client.transport.Transport;
import org.apache.juddi.v3_service.JUDDIApiPortType;
import org.apache.juddi.api_v3.*;
import org.apache.juddi.v3.client.*;
import org.apache.juddi.v3.client.config.*;

public class JuddiFind {

  public static void main(String[] args) {
    JuddiProperties juddiProps=new JuddiProperties();
    juddiProps.setAuthorizedName("AuthorisedName");
    juddiProps.setPublisherName("MyPublisher");
    //juddiProps.setBusinessName("MyBusinessMetro");
    juddiProps.setBusinessName("MyBusinessAxis");
    //juddiProps.setServiceName("CmmdcWSService");
    juddiProps.setServiceName("CmmdcService");
    juddiProps.setServiceLang("RO");
    juddiProps.setServiceDesc("Calculul celui mai mic divizor comun a doua numere");
    juddiProps.setServiceKeyWord("cmmdc");
    //juddiProps.setWsdlURL("http://localhost:8080/jaxws-cmmdc/cmmdcws?wsdl");
    juddiProps.setWsdlURL("http://localhost:8080/axis2/services/CmmdcWSService?wsdl");
    juddiProps.setAccessPointType("wsdlDeployment");
    
    JuddiUtil juddiUtil=new JuddiUtil();
    JuddiElems juddiElems=juddiUtil.init();
    if(juddiElems!=null){
       find(juddiProps,juddiElems);
    }
    System.out.println("Sfarsit");
  }
  
  public static void find(JuddiProperties juddiProps, JuddiElems juddiElems){
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
   // cautarea inregistrarilor in BD jUDDI
      GetAuthToken getAuthTokenMyPub = new GetAuthToken();
      getAuthTokenMyPub.setUserID(authorizedName);
      getAuthTokenMyPub.setCred("");
      org.uddi.api_v3.AuthToken myPubAuthToken = securityPortType.getAuthToken(getAuthTokenMyPub);
      System.out.println ("myPub AUTHTOKEN = " + myPubAuthToken.getAuthInfo());
   
   // Find service  
      FindService find=new FindService();   
      find.setAuthInfo(rootAuthToken.getAuthInfo());
      find.setMaxRows(10);
      find.setListHead(0);
      
      FindTModel findModel=new FindTModel();
      Name findName=new Name();
      findName.setValue(serviceName);
      findModel.setListHead(0);				
      findModel.setMaxRows(10);     
      findModel.setAuthInfo(rootAuthToken.getAuthInfo());
      find.getName().add(findName);
 
      FindQualifiers qualifiers=new FindQualifiers();
      //qualifiers.getFindQualifier().add("uddi-org:approximateMatch");
      qualifiers.getFindQualifier().add(org.apache.juddi.query.util.FindQualifiers.APPROXIMATE_MATCH);
      findModel.setFindQualifiers(qualifiers);     
      find.setFindQualifiers(qualifiers);
      
      ServiceList foundList = inquiryPortType.findService(find);
 
      if(foundList.getServiceInfos()!=null){
        if(foundList.getServiceInfos().getServiceInfo()!=null){
          System.out.println(
            "Servicii gasite "+ foundList.getServiceInfos().getServiceInfo().size()+"\n");           
          System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); 
          for(ServiceInfo info:foundList.getServiceInfos().getServiceInfo()){
            System.out.println("Nume: "+info.getName().get(0).getValue()); 
            GetServiceDetail serviceDetail=new GetServiceDetail();
            serviceDetail.getServiceKey().add(info.getServiceKey());
            serviceDetail.setAuthInfo(rootAuthToken.getAuthInfo());
            ServiceDetail details = inquiryPortType.getServiceDetail(serviceDetail);        
            System.out.println("WSDL: "+
                details.getBusinessService().get(0).getBindingTemplates().
                getBindingTemplate().get(0).getAccessPoint().getValue());
          }      
        }  
        else{
          System.out.println("\n Ooops: foundList.getServiceInfos().getServiceInfo()=null!\n");
        }
      }
      else{
        System.out.println("\n Ooops: foundList.getServiceInfos()=null!\n");  
      }   
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
