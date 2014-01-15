<%@ page import="org.apache.xmlrpc.*,org.apache.xmlrpc.client.*,java.net.*" %>
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
       String surl = "http://localhost:8080/xmlrpcserver/xmlrpc";
       String sm=request.getParameter("m");
       String sn=request.getParameter("n");
       
       //out.println(sm+" "+sn);     
       long m=((sm==null)||("".equals(sm)))?1:Long.parseLong(sm);       
       long n=((sn==null)||("".equals(sn)))?1:Long.parseLong(sn);
       //out.println(m+" "+n);
       try{    
         url=new URL(surl);
       }
       catch(MalformedURLException e){  
         out.println("MalformedURLException : "+e.getMessage());     
       }
       XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
       config.setServerURL(url);
       config.setEnabledForExtensions(true);
       XmlRpcClient client = new XmlRpcClient();
       client.setConfig(config);
       Object[] params = new Object[]{new Long(m), new Long(n)};
       try{
         Long result = (Long) client.execute("MyService.cmmdc", params);
         out.println("Raspuns : "+result.toString()); 
       }
       catch(XmlRpcException e){
         outprintln("XmlRpcException : "+e.getMessage());     
       }
    %>   
  </body>
</html>
