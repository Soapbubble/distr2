package server.resources;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
//import org.restlet.resource.ResourceException;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.FileRepresentation;
import java.io.File;

public class HtmlResource extends ServerResource{  
  @Get
  public Representation resursaHtml(){// throws ResourceException{
    File f=new File("webapps/myrestlet/exemplu.html");
    Representation representation = 
      new FileRepresentation(f,MediaType.TEXT_HTML);
    return representation;  
  }
}
