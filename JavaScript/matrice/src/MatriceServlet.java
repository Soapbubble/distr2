import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MatriceServlet extends HttpServlet{ 
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    String sm=req.getParameter("m");
    String sn=req.getParameter("n");  
    int m=Integer.parseInt(sm);  
    int n=Integer.parseInt(sn);
    double[][] a =new double[m][n];
    for (int i=0;i<m;i++){
      for (int j=0;j<n;j++){     
        String element=
          req.getParameter("a"+Integer.toString(i)+Integer.toString(j));  
          a[i][j]=Double.parseDouble(element);
      }
    }
    PrintWriter out=res.getWriter();   
    res.setContentType("text/plain");
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++)
        out.print(a[i][j]+" ");
      out.println();
    }
    /*
    String x=toString(a);
    PrintWriter out=res.getWriter();   
    if(tip.equals("text/html")){
      String title="Matrice Servlet";
      res.setContentType("text/html");
      out.println("<HTML><HEAD><TITLE>");
      out.println(title);
      out.println("</TITLE></HEAD><BODY>");
      out.println("<H1>"+title+"</H1>");
      out.println("<TEXTAREA readonly="+"readonly"+">Matricea introdusa este:");
      out.println(x);
      out.println("</TEXTAREA>");
      out.println("</BODY></HTML>");
    }
    else{
      res.setContentType("text/plain");
      out.println(x);
    }
    */
    out.close();   
  }
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    doGet(req,res);
  }
  /* 
  public String toString(int[][]a) {
          String st="";
    	for (int i=0;i<a.length;i++){ 
                   for (int j=0;j<a[i].length;j++)
    	                 st+=a[i][j]+" ";
    	  st+="\n";
                 }
         return st;
    }
   */
}