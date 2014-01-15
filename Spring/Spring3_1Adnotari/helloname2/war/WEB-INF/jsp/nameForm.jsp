<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
<body>
	<h1>Aplicatie Spring cu formular pentru date</h1>
 
	<form:form method="post">
 
		<p> Introduceti numele: 
		
		<form:input path="nume"/> </p>
 
		
		<input type="submit" value="Submit">
 
	</form:form>
</body>
</html>

