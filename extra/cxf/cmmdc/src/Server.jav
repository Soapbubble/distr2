package server.cmmdc;
import javax.xml.ws.Endpoint;

public class Server {

  protected Server() throws Exception {
    System.out.println("Starting Server");
    CmmdcImpl implementor = new CmmdcImpl();
    //String address = "http://localhost:8080/jaxws-cxf-cmmdc/services/cmmdc";
    String address = "http://localhost:9000/jaxws-cxf-cmmdc"; 
    Endpoint.publish(address, implementor);     
  }
  
  public static void main(String args[]) throws Exception {
    new Server();
    System.out.println("Server ready...");

    Thread.sleep(5 * 60 * 1000);
    System.out.println("Server exiting");
    System.exit(0);
  }
  
}
