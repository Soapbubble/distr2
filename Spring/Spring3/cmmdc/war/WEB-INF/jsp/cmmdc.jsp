<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
-->

<html>
  <body>
    <h1> Calculul celui mai mare divizor comun </h1>
    <p> 
    Cmmdc(<c:out value="${sm}"/>,<c:out value="${sn}"/>)=<c:out value="${message}"/>
    </p>
    <p>
    <a href="<c:url value="cmmdcdata.htm"/>">Reluare</a>
    </p>
  </body>
</html>
