import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AJAXAlegereServlet extends HttpServlet{
  public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{
    String materia=req.getParameter("alegere");
    //System.out.println("Materia:"+materia);
    PrintWriter out=res.getWriter();
    res.setContentType("text/html");
    out.println("<html><body>");
    out.println("<h1> Disciplina optionala selectata </h1>");
    out.println("<p>"+materia);
    out.println("</body></html>");
    out.close();
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{
    doGet(req,res);
  }
}