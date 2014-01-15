<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
<body>
	<h1>Adrese de E-mail - Aplicatie Spring </h1>
	<p/>
	<h3> Inserarea unei inregistrari </h3>
  <p/> 
	<form:form method="post"> 
		Introduceti
    <table border="1">
       <tr>
          <td> Numele </td>
          <td> <form:input path="nume"/> </td>
       </tr>
       <tr>
          <td> Adresa e-mail </td>
          <td> <form:input path="email"/> </td>
       </tr>
		   <tr>
		      <td/>
		      <td>	<input type="submit" value="Executa"> </td>
		      <td/>
		   </tr>
		 </table>  
	</form:form>
</body>
</html>

