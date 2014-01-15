package client;
import org.restlet.resource.ClientResource;
//import org.restlet.representation.Representation;

public class MyClient{
  public static void main(String[] args){
    if(args.length==0){
      System.out.println("Usage: java MyClient URI");
      System.exit(1);
    }
    String baseURI=args[0];
    ClientResource clientRes=new ClientResource(baseURI);
    
    System.out.println("Resursa TEXT\n");
    try{
      //Representation representation=client.get();
      //representation.write(System.out);
      clientRes.get().write(System.out);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
    
    System.out.println("\nResursa HTML\n");
    clientRes=new ClientResource(baseURI+"/html");
    try{
      clientRes.get().write(System.out);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
   
    System.out.println("\nResursa XML\n");
    clientRes=new ClientResource(baseURI+"/xml");
    try{
      clientRes.get().write(System.out);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
    
    System.out.println("\nResursa fisier HTML\n");
    clientRes=new ClientResource(baseURI+"/htmlfile");
    try{
      clientRes.get().write(System.out);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}