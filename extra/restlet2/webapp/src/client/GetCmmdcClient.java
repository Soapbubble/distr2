package client;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.data.Method;
import java.util.Scanner;

public class GetCmmdcClient{
  public static void main(String[] args){
    if(args.length==0){
      System.out.println("Usage: java GetCmmdcClient URI");
      System.exit(1);
    }
    String baseURI=args[0];
    
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    String m=scanner.next();
    System.out.println("n=");
    String n=scanner.next();
    
    String uri=baseURI+"/getcmmdc?m="+m+"&n="+n;
    
    ClientResource client=new ClientResource(Method.GET,uri);
    Representation representation=client.get();
    try{
      representation.write(System.out);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}