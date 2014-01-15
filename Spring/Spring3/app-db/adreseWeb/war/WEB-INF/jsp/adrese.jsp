<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <body>
    <h1> Rezultatul actiunii</h1>
    <c:out value="${message}"/>
    <p/>
    <c:if test="${model.listaAdrese!=null}">
      <h1>Lista adreselor de e-mail</h1>
      <h3>Adrese</h3>
      <c:forEach items="${model.listaAdrese}" var="a">
        <c:out value="${a.id}"/> 
        <i><c:out value="${a.nume}"/></i> 
        <c:out value="${a.email}"/>
        <br><br>
      </c:forEach>
    </c:if>
    <a href="<c:url value="/index.jsp"/>">Reluare</a>
  </body>
</html>
