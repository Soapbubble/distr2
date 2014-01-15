import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AJAXCmmdcServlet extends HttpServlet{

  public long cmmdc(long m, long n){
    long r,c;
    do{
      c=n;
      r=m%n;
      m=n;
      n=r;
    } 
    while(r!=0);
    return c;
  }   
 
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    String sm=req.getParameter("m"),sn=req.getParameter("n");
    long m=Long.parseLong(sm),n=Long.parseLong(sn);
    String tip=req.getParameter("tip");
    long x=cmmdc(m,n);
    PrintWriter out=res.getWriter();
    res.setHeader("Cache-Control","no-cache");
    if(tip.equals("xml")){
      res.setContentType("text/xml");     
      out.print("<?xml version=\"1.0\" ?>");
      out.print("<rezultat>");
      out.print((new Long(x)).toString());
      out.print("</rezultat>");
    }
    else{
      res.setContentType("text/plain");
      out.println((new Long(x)).toString());
    }
    out.close();
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{
    doGet(req,res);
  }
}
