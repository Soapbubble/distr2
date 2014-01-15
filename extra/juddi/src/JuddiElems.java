package juddi;

import org.apache.juddi.v3_service.JUDDIApiPortType;
import org.uddi.v3_service.UDDIPublicationPortType;
import org.uddi.v3_service.UDDISecurityPortType;
import org.uddi.v3_service.UDDIInquiryPortType;

public class JuddiElems{
  private UDDISecurityPortType securityPortType;
  private JUDDIApiPortType apiPortType;
  private UDDIPublicationPortType publicationPortType;
  private UDDIInquiryPortType inquiryPortType;
  private org.uddi.api_v3.AuthToken rootAuthToken;
  
  public void setSecurityPortType(UDDISecurityPortType securityPortType){
    this.securityPortType=securityPortType;
  }
  public UDDISecurityPortType getSecurityPortType(){
    return securityPortType;
  }
  
  public void setApiPortType(JUDDIApiPortType apiPortType){
    this.apiPortType=apiPortType;
  }
  public JUDDIApiPortType getApiPortType(){
    return apiPortType;
  }
  
  public void setPublicationPortType(UDDIPublicationPortType publicationPortType){
    this.publicationPortType=publicationPortType;
  }
  public UDDIPublicationPortType getPublicationPortType(){
    return publicationPortType;
  }
   
  public void setInquiryPortType(UDDIInquiryPortType inquiryPortType){
    this.inquiryPortType=inquiryPortType;
  }
  public UDDIInquiryPortType getInquiryPortType(){
    return inquiryPortType;
  }
  
  public void setRootAuthToken(org.uddi.api_v3.AuthToken rootAuthToken){
    this.rootAuthToken=rootAuthToken;
  }
  public org.uddi.api_v3.AuthToken getRootAuthToken(){
    return rootAuthToken;
  }
}
