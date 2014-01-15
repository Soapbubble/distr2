<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
-->

<html>
  <body>
    <h1> Rezultatul cautarii </h1>
    <table border="1">
      <tr>
         <td> Numele judetului </td>
         <td> <c:out value="${nume}"/></td>
      </tr>      
      <tr>
         <td> Capitala judetului </td>
         <td> <c:out value="${capitala}"/></td>
      </tr>
      <tr>
         <td> Abrevierea judetului </td>
         <td> <c:out value="${abrevierea}"/></td>
      </tr>
    </table>
  </body>
</html>
