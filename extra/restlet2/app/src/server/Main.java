package server;
import org.restlet.Component;
//import org.restlet.VirtualHost;
import org.restlet.data.Protocol;
//import org.restlet.util.ServerList;

public class Main{
  public static void main(String[] args) {
    try {
      Component component = new Component();
      // Add a new HTTP server listening on port 8182.
      //ServerList sl=component.getServers();
      //sl.add(Protocol.HTTP, 8182);
      component.getServers().add(Protocol.HTTP, 8182);
      
      //VirtualHost vh=component.getDefaultHost();
      //vh.attach("/hello",new MyRestlet());
      component.getDefaultHost().attach(new server.MyRestlet());
      
      component.start();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
