package server.resources;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
/*
import org.restlet.resource.ResourceException;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
*/

public class MyHtmlResource extends ServerResource {  
  @Get
  public String resursaHtml(){
    return "<html><body bgcolor=\"AAEEAA\">"+
        "<h1>Felicitari pentru primul Restlet</h1></body><html>";
  }
  
  /*
  public Representation get() throws ResourceException{
    Representation representation = 
      new StringRepresentation("<html><body bgcolor=\"AAEEAA\">"+
        "<h1>Felicitari pentru primul Restlet</h1></body><html>",
        MediaType.TEXT_HTML);
    return representation;
  }
  */
}
