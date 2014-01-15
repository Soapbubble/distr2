package server.resources;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
/*
import org.restlet.resource.ResourceException;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
*/

public class MyTextResource extends ServerResource {  
  @Get
  public String resursaText(){
    return "Felicitari pentru primul Restlet";
  }

  /*
  public Representation get() throws ResourceException{
    Representation representation = 
      new StringRepresentation("Felicitari pentru primul Restlet",
        MediaType.TEXT_PLAIN);
    return representation;
  }
  */
}
