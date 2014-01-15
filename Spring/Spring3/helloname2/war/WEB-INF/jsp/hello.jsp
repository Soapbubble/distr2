<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
-->

<html>
  <body>
    <h1><c:out value="${message}"/></h1>
    <p> Date <c:out value="${date}"/> </p>
    
    <p>
    <!--
    <a href="http://localhost:8080/newname">Reluare</a>
    -->
    <a href="<c:url value="newname.htm"/>">Reluare</a>
  </body>
</html>
