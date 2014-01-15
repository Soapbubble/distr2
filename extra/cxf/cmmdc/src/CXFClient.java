package client;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import server.cmmdc.Cmmdc;
import java.util.Scanner;

public final class CXFClient {

  private static final QName SERVICE_NAME 
      = new QName("http://cmmdc.server/", "Cmmdc");  //<wsdl:portType name=
  private static final QName PORT_NAME 
      = new QName("http://cmmdc.server/", "CmmdcPort"); //<wsdl:port name=

  private CXFClient(){} 

  public static void main(String args[]) throws Exception {
    Service service = Service.create(SERVICE_NAME);
    // Endpoint Address
    //String endpointAddress = "http://localhost:9000/helloWorld";
    String endpointAddress = "http://localhost:8080/jaxws-cxf-cmmdc/services/cmmdc";
    
    // Add a port to the Service
    service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
    
    Cmmdc obj = service.getPort(Cmmdc.class);
    
    Scanner scanner=new Scanner(System.in);
    System.out.println("Primul numar : ");
    long m=scanner.nextLong();
    System.out.println("Al doilea numar : ");
    long n=scanner.nextLong();
    long r=obj.cmmdc(m,n);
    
    System.out.println("Cmmdc : "+r);

  }
}
