package server.resources;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.restlet.resource.ResourceException;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.ext.xml.DomRepresentation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MyXmlResource extends ServerResource { 
  @Get
  public Representation resursaXml(){// throws ResourceException{
    try{
      DomRepresentation representation = 
        new DomRepresentation(MediaType.TEXT_XML);
      Document d=representation.getDocument();
      Element msgElem=d.createElement("mesaj");
      d.appendChild(msgElem);
      msgElem.appendChild(d.createTextNode("Felicitari pentru primul Restlet"));
      d.normalizeDocument(); 
      return representation;
    }
    catch(Exception e){
      System.out.println("DomRepresentationException : "+e.getMessage());
    }
    return null;
  }
}
