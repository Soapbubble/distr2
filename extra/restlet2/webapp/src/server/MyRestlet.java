package server;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class MyRestlet extends Application {
  public synchronized Restlet createInboundRoot() {
    Router router = new Router(getContext());
    router.attachDefault(server.resources.MyTextResource.class);
    router.attach("/html",server.resources.MyHtmlResource.class);
    router.attach("/xml",server.resources.MyXmlResource.class);
    router.attach("/jpg",server.resources.MyImageResource.class);
    router.attach("/htmlfile",server.resources.HtmlResource.class);
    router.attach("/postcmmdc",server.resources.PostCmmdcResource.class);
    router.attach("/getcmmdc",server.resources.GetCmmdcResource.class);
    return router;
  }
}
