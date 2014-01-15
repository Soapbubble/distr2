<%@ page import="com.caucho.hessian.client.HessianProxyFactory,hessianapp.MyService" %>
<html>
  <body>
    <h1> Cmmdc </h1>
    <form method="post">   
        <table>
          <tr>
            <td>Primul numar este </td>
            <td><input type="text" name="m" size=5 value="1"> </td>
          </tr>
          <tr>
            <td>Al doilea numar este </td>
            <td><input type="text" name="n" size=5 value="1"> </td>
          </tr>
          <tr>
            <td><input type="submit" value="Calculeaza"></td>
            <td/>
          </tr>
        </table>          
    </form>
    <%
       String url = "http://localhost:8080/hessian/hessianservice";
       HessianProxyFactory factory = new HessianProxyFactory();
       MyService myService = (MyService) factory.create(MyService.class, url);
       String sm=request.getParameter("m");
       String sn=request.getParameter("n");
       
       //out.println(sm+" "+sn);     
       long m=((sm==null)||("".equals(sm)))?1:Long.parseLong(sm);       
       long n=((sn==null)||("".equals(sn)))?1:Long.parseLong(sn);
       //out.println(m+" "+n);
       out.println("Raspuns : "+myService.cmmdc(m,n));
    %>   
  </body>
</html>
