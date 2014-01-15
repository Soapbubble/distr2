package resources;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@WebServlet(urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException {
    String sm=req.getParameter("m");
    String sn=req.getParameter("n");
    String tip=req.getParameter("tip");
    System.out.println(sm+" : "+sn+" : "+tip);  
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target("http://"
            + req.getServerName()
            + ":"
            + req.getServerPort()
            + req.getContextPath()
            + "/resources/cmmdc");
    CmmdcBean bean=new CmmdcBean();
    bean.setSm(sm);
    bean.setSn(sn);    
    CmmdcBean obj = target
            .request()
            .post(Entity.entity(bean, MediaType.APPLICATION_JSON), CmmdcBean.class);
    PrintWriter out = res.getWriter();       
    if(tip.equals("text/html")){
      res.setContentType("text/html;charset=UTF-8");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet TestServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet TestServlet at " + req.getContextPath() + "</h1>");
      System.out.println("POST req");
      out.println("Received res: " + obj.getResult() + "<br><br>");
      out.println("</body>");
      out.println("</html>");
    }
    else{
      res.setContentType("text/plain;charset=UTF-8");
      out.println(obj.getResult());
    }    
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException {
    doGet(req, res);
  }
}
