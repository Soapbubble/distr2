<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <body>
    <center>
    <f:view>
    <p>
    <h:outputText value="Fisierul #{uploadBean.uploadedFileName} a fost incarcat cu succes !" />
    </p>
    </f:view>
    <p>
    <a href="uploadInput.faces"> O alt&#259; &#238;nc&#259;rcare</a>
    </p>
    </center>
  </body>
</html>