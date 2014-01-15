<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <body>
    <h1> Agenda de adrese e-mail </h1>
    <p/>
    <form method="post">
  	  <h3>Selecta&#355;i </h3>
  	  <table border="1">
    	   <tr>
    	     <td> <h3>Opera&#355;ia </h3></td>
    	     <td>
        	   <select name="operatia">
        	     <option value="1">Inserarea unei &#238;nregistr&#259;ri 
        	     <option value="2">Stergerea unei &#238;nregistr&#259;ri 
        	     <option value="3">Actualizarea unei &#238;nregistr&#259;ri 
        	     <option value="4">Lista &#238;nregistr&#259;rilor 
        		 </select>
        	 </td>	
         </tr>
  		   <tr>
  		      <td/>
  		      <td>	<input type="submit" value="Continua"> </td>
  		   </tr>
		 </table>  
	</form>
  <% 
     String operatia=request.getParameter("operatia");
     if(operatia!=null){
       int prel=0;
       if(operatia.equals("1"))prel=1;
       if(operatia.equals("2"))prel=2;
       if(operatia.equals("3"))prel=3;
       if(operatia.equals("4"))prel=4;
       switch(prel){
         case 1:
  %>     
            <c:redirect url="/create.htm"/>
  <%
            break;
         case 2:
  %>      
          <c:redirect url="/delete.htm"/>
  <%
            break;
         case 3:
  %>       
            <c:redirect url="/update0.htm"/>
  <%
            break;
         case 4:
  %>       
            <c:redirect url="/read.htm"/>
  <%
            break;           
       }   
     }
  %>   
  </body>
</html>
