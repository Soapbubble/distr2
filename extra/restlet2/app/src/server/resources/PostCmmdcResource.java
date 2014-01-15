package server.resources;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
//import org.restlet.resource.ResourceException;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.data.Form;

public class PostCmmdcResource extends ServerResource {  
  @Post
  public Representation compute(Representation entity){// throws ResourceException{
    Form form=new Form(entity);
    String sm=form.getFirstValue("m");
    String sn=form.getFirstValue("n");
    long m=Long.parseLong(sm),n=Long.parseLong(sn);  
    long x=cmmdc(m,n);
    String r=new Long(x).toString();
    System.out.println("m = "+m+" n = "+n);
    Representation representation = 
      new StringRepresentation("Cmmdc = "+r,MediaType.TEXT_PLAIN);
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
