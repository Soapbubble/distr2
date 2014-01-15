package server.resources;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
//import org.restlet.resource.ResourceException;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
//import org.restlet.Request;

public class GetCmmdcResource extends ServerResource {  
  @Get
  public Representation compute(){ //throws ResourceException{
    //Request request=getRequest();
    String  sRequest=getRequest().getResourceRef().toString();
    int index=sRequest.indexOf("?");
    String d=sRequest.substring(index+1);
    int i0=d.indexOf("m=");
    int i1=d.indexOf("n=");
    String sm=d.substring(i0+2,i1-1);
    String sn=d.substring(i1+2);
    System.out.println(sm+" "+sn);
    long m=Long.parseLong(sm);
    long n=Long.parseLong(sn);
    long x=cmmdc(m,n);
    String r=new Long(x).toString();
    System.out.println("m = "+m+" n = "+n);
    Representation representation = 
      new StringRepresentation("Cmmdc = "+r, MediaType.TEXT_PLAIN);
    return representation;
  }
  
  private long cmmdc(long m, long n){
    long r,c;
    do{
      c=n;
      r=m%n;
      m=n;
      n=r;
    }
    while(r!=0);
    return c;
  }   
}
