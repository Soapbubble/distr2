<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <body>
    <h1><c:out value="${message}"/></h1>
    <p> Date <c:out value="${date}"/> </p>
    <p>
    <a href="<c:url value="helloworld.htm"/>">Reluare</a>
    </p>
  </body>
</html>
