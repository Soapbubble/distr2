<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
<body>
	<h1>Adrese de E-mail - Aplicatie Spring </h1>
	<p/>
	<h3> Stergerea unei interistrari </h3>
  <p/> 
	<form:form method="post">
	  Introduceti cheia inregitrarii
    <table border="1">
       <tr>
          <td> Id </td>
          <td> <form:input path="sid"/> </td>
          <td> <form:errors path="sid"/> </td>
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

