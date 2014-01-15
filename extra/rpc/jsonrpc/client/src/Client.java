import org.json.rpc.client.HttpJsonRpcClientTransport;
import org.json.rpc.client.JsonRpcInvoker;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Client{
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    
    String surl="http://localhost:8080/jsonrpc/jsonrpc";
    URL url=null;
    try{
      url=new URL(surl);
    }
    catch(MalformedURLException e){
      System.err.println("MalformedURLException "+surl);
      System.exit(1);
    }  
    HttpJsonRpcClientTransport transport=new HttpJsonRpcClientTransport(url);
    JsonRpcInvoker invoker=new JsonRpcInvoker();
    MyService service=invoker.get(transport,"hello",MyService.class);
    
    System.out.println("Introduveti numele d-voastra:");
    String nume=scanner.next();
    String msg=service.sayHello(nume);
    System.out.println(msg);
    
    service=invoker.get(transport,"cmmdc",MyService.class);
    System.out.println("Aplicatia CMMDC");
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong(); 
    long rez=service.cmmdc(m,n);
    System.out.println("Cmmdc : "+rez);
  }
}

