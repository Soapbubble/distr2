package hw;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation; 
import javax.ws.rs.core.MediaType;

public class JerseyClient {
  public static void main(String args[]) {
    Client client = ClientBuilder.newClient();  
    String response="";
    WebTarget webTarget=client.target("http://localhost:8080/HelloWorld/resources/helloworld");
    Invocation.Builder invocationBuilder=webTarget.request(MediaType.TEXT_PLAIN_TYPE);
    response=invocationBuilder.get(String.class);
    System.out.println(response);
    System.out.println(); 
    invocationBuilder=webTarget.request(MediaType.TEXT_HTML_TYPE);
    response=invocationBuilder.get(String.class);
    System.out.println(response);
    System.out.println(); 
    invocationBuilder=webTarget.request(MediaType.TEXT_XML_TYPE);
    response=invocationBuilder.get(String.class);
    System.out.println(response);
    System.out.println(); 
  }
}
