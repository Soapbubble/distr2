package cmmdc;

import javax.xml.namespace.QName;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class CmmdcWSBean{  
  private String m="";
  private String n="";
  
  public void setM(String m){
     this.m=m;
  }
  public void setN(String n){
     this.n=n;
  }
  public String getM(){
     return m;
  }
  public String getN(){
     return n;
  }
  
  public String getCmmdc() throws AxisFault {
    long m=Long.parseLong(getM());
    long n=Long.parseLong(getN());
	
	  RPCServiceClient serviceClient = new RPCServiceClient();
    Options options = serviceClient.getOptions();
    EndpointReference targetEPR = 
      new EndpointReference("http://localhost:8080/axis2/services/CmmdcWSService");
    options.setTo(targetEPR);
    
    // Getting the GCD
    QName opGetCmmdc = new QName("http://server.cmmdc", "cmmdc");

    Object[] opGetCmmdcArgs = new Object[] {m,n };
    Class[] returnTypes = new Class[] { Long.class };
    
    Object[] response = serviceClient.invokeBlocking(opGetCmmdc,
            opGetCmmdcArgs, returnTypes);
    
    Long result = (Long) response[0];
    if (result == null) {
        return "-1";
    }
    else{
      return result.toString();
    }
  }
}
