<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
<body>
	<h1>Cmmdc - Aplicatie Spring </h1>
 
	<form:form method="post">
    <table border="1">
       <tr>
          <td> Primul numar </td>
          <td> <form:input path="sm"/> </td>
          <td> <form:errors path="sm"/> </td>
        </td>

       </tr>
       <tr>
          <td> Al doilea numar </td>
          <td> <form:input path="sn"/> </td>
          <td> <form:errors path="sn"/> </td>
       </tr>
		   <tr>
		      <td/>
		      <td>	<input type="submit" value="Calculeaza"> </td>
		      <td/>
		   </tr>
		 </table>  
	</form:form>
</body>
</html>

