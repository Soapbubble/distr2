package juddi;

import org.uddi.api_v3.*;
import org.uddi.v3_service.*;
import org.apache.juddi.v3.client.transport.Transport;
import org.apache.juddi.v3_service.JUDDIApiPortType;
import org.apache.juddi.api_v3.*;
import org.apache.juddi.v3.client.*;
import org.apache.juddi.v3.client.config.*;

public class JuddiUtil{
  public static JuddiElems init(){
    JuddiElems juddiElems=null;
    try{
      String clazz = UDDIClientContainer.getUDDIClerkManager(null).
        getClientConfig().getUDDINode("default").getProxyTransport();      
      Class<?> transportClass = ClassUtil.forName(clazz, Transport.class);
      if (transportClass!=null){
        Transport transport = (Transport) transportClass.
          getConstructor(String.class).newInstance("default");
        UDDISecurityPortType securityPortType = transport.getUDDISecurityService();
        JUDDIApiPortType apiPortType = transport.getJUDDIApiService();
        UDDIPublicationPortType publicationPortType = transport.getUDDIPublishService();
        UDDIInquiryPortType inquiryPortType = transport.getUDDIInquiryService();
    
     // Fixarea datelor de autentificare a utilizatorului 'user'
     // cu drepturi de administrator
        GetAuthToken getAuthTokenRoot = new GetAuthToken();
        getAuthTokenRoot.setUserID("root");
        getAuthTokenRoot.setCred("");
        org.uddi.api_v3.AuthToken rootAuthToken = securityPortType.getAuthToken(getAuthTokenRoot);
        System.out.println ("root AUTHTOKEN = " + rootAuthToken.getAuthInfo());
        
        juddiElems=new JuddiElems();
        juddiElems.setSecurityPortType(securityPortType);
        juddiElems.setApiPortType(apiPortType);
        juddiElems.setPublicationPortType(publicationPortType);
        juddiElems.setInquiryPortType(inquiryPortType);
        juddiElems.setRootAuthToken(rootAuthToken);
      }
      else{
        System.out.println("TransportClass=null");
      }
    }
    catch(Exception e){
       System.out.println("InitException : "+e.getMessage());
    }  
    return juddiElems;    
  }     
}
