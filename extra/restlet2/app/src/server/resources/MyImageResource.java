package server.resources;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
//import org.restlet.resource.ResourceException;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.FileRepresentation;
import java.io.File;

public class MyImageResource extends ServerResource {  
  @Get
  public Representation imagine(){// throws ResourceException{
    File f=new File("images/forest.jpg");
    Representation representation = 
      new FileRepresentation(f,MediaType.IMAGE_JPEG);
    return representation;
  }
}
