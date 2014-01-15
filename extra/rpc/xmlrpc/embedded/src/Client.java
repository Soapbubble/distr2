package xmlrpcclient;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.XmlRpcException;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;

public class Client{
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong(); 
    URL url=null;
    try{    
      url=new URL("http://localhost:8080");
    }
    catch(MalformedURLException e){  
      System.err.println("MalformedURLException : "+e.getMessage()); 
      System.exit(1);      
    }
    XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    config.setServerURL(url);
    config.setEnabledForExtensions(true);
    XmlRpcClient client = new XmlRpcClient();
    client.setConfig(config);
    Object[] params = new Object[]{new Long(m), new Long(n)};
    try{
      Long result = (Long) client.execute("MyService.cmmdc", params);
      System.out.println("Raspuns : "+result.toString()); 
    }
    catch(XmlRpcException e){
      System.err.println("XmlRpcException : "+e.getMessage());     
    }
  }
}  