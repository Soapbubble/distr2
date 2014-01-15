package client;
import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation;
import org.restlet.data.Method;
import org.restlet.data.Form;
import java.util.Scanner;

public class PostCmmdcClient{
  public static void main(String[] args){
    if(args.length==0){
      System.out.println("Usage: java MyClient URI");
      System.exit(1);
    }
    String baseURI=args[0]; 
    Scanner scanner=new Scanner(System.in);
    System.out.println("m=");
    long m=scanner.nextLong();
    System.out.println("n=");
    long n=scanner.nextLong();
    Form form=new Form();
    form.add("m",new Long(m).toString());
    form.add("n",new Long(n).toString());
    
    Representation representation=form.getWebRepresentation();
    ClientResource client=new ClientResource(Method.POST,baseURI+"/postcmmdc");
    representation=client.post(representation);
    try{
      representation.write(System.out);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}