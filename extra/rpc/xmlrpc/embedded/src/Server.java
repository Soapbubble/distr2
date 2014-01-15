package xmlrpcserver;
import java.net.InetAddress;

//import org.apache.xmlrpc.common.TypeConverterFactoryImpl;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
//import org.apache.xmlrpc.webserver.ServletWebServer;
//import org.apache.xmlrpc.webserver.XmlRpcServlet;
import org.apache.xmlrpc.webserver.WebServer;

public class Server {
  private static final int port = 8080;
  
  public static void main(String[] args) throws Exception {
    //XmlRpcServlet servlet = new XmlRpcServlet();
    //ServletWebServer webServer = new ServletWebServer(servlet, port);
    WebServer webServer=new WebServer(port);
    XmlRpcServer server = webServer.getXmlRpcServer();
    
    //XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) webServer.getConfig();
    XmlRpcServerConfigImpl config = new XmlRpcServerConfigImpl();
    config.setEnabledForExtensions(true);
    server.setConfig(config);
    
    PropertyHandlerMapping phm = new PropertyHandlerMapping();
    phm.addHandler("MyService",xmlrpcserver.MyService.class);
    server.setHandlerMapping(phm);
    
    webServer.start();
  }
}