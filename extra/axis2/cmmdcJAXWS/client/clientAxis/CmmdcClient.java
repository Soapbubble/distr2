import javax.xml.namespace.QName;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import java.util.Scanner;
//import org.apache.log4j.*;

public class CmmdcClient {
  //static Logger logger = Logger.getLogger(CmmdcClient.class);
  
  public static void main(String[] args) throws AxisFault {
    
    RPCServiceClient serviceClient = new RPCServiceClient();
    Options options = serviceClient.getOptions();
    EndpointReference targetEPR = 
      new EndpointReference("http://localhost:8080/axis2/services/CmmdcWSService");
    options.setTo(targetEPR);
    
    Scanner scanner=new Scanner(System.in);
    System.out.println("Primul numar:");
    Long m=new Long(scanner.next());
    System.out.println("Al doilea numar:");
    Long n=new Long(scanner.next());
    
    // Getting the GCD
    QName opGetCmmdc = new QName("http://server.cmmdc", "cmmdc");
    
    Object[] opGetCmmdcArgs = new Object[] {m,n };
    Class[] returnTypes = new Class[] { Long.class };
    
    Object[] response = serviceClient.invokeBlocking(opGetCmmdc,
            opGetCmmdcArgs, returnTypes);
    
    Long result = (Long) response[0];
    if (result == null) {
        System.out.println("No result");
    }
    else{
      System.out.println("Cmmdc:"+result.longValue());
    }
  }
}