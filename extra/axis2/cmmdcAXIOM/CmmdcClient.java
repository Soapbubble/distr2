import org.apache.axiom.om.*;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import java.util.Scanner;

public class CmmdcClient {
	public static void main(String[] args) {
		try {
  		Scanner scanner=new Scanner(System.in);
      System.out.println("Primul numar:");
      String m=scanner.next();
      System.out.println("Al doilea numar:");
      String n=scanner.next();
         
			EndpointReference endpointURL = new EndpointReference(
					"http://localhost:8080/axis2/services/CmmdcService");
			Options options = new Options();
			options.setAction("calculeazaCmmdc");
			options.setTo(endpointURL);

			OMFactory factory = OMAbstractFactory.getOMFactory();
			OMNamespace omNs = factory.createOMNamespace(
					"http://cmmdc", "cmmdc");
			OMElement method = factory.createOMElement("calculeazaCmmdc", omNs);
      String mydata=m+","+n;
			OMText param = factory.createOMText(mydata);
			method.addChild(param);

			ServiceClient client = new ServiceClient();
			client.setOptions(options);
			OMElement result = client.sendReceive(method);
			System.out.println("cmmdc="+result.getText());
		} 
		catch (Exception e) {
			  System.out.println("Exception : "+e.getMessage());
		}
	}
}
