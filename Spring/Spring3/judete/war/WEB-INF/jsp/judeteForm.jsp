<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
<body>
	<h1>Informatii despre judete - Aplicatie Spring </h1>
 
	<form:form method="post">
    Selectati judetul din lista 
     
	  <form:select path="nume">
		   <form:options items="${lstJud}"/> 
		</form:select>
		
		<p><input type="submit" value="Cauta"></p>
	</form:form>
</body>
</html>

