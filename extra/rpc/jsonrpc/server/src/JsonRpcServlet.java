import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet; 
import org.json.rpc.server.JsonRpcExecutor;
import org.json.rpc.server.JsonRpcServletTransport;

@WebServlet(urlPatterns = "/jsonrpc") 

public class JsonRpcServlet extends HttpServlet{
  private final JsonRpcExecutor executor;
  
  public JsonRpcServlet(){
    executor=bind();
  }

  private JsonRpcExecutor bind(){
    JsonRpcExecutor executor=new JsonRpcExecutor();
    MyService service=new MyServiceImpl();
    executor.addHandler("cmmdc",service,MyService.class);
    executor.addHandler("hello",service,MyService.class);
    return executor;
  }  
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
     throws ServletException,IOException{
    executor.execute(new JsonRpcServletTransport(req,res));
  }
}
