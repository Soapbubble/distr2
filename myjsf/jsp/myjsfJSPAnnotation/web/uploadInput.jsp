<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<html>
  <head>
      <title>File upload test</title>
  </head>
  <body>
    <h1> &#206;nc&#259;rcarea unui fi&#351;ier </h1>
    <f:view>
    <h:form id="uploadForm" enctype="multipart/form-data">
      <div>
        <h:outputLabel value="Alegeti fisierul" />
        <t:inputFileUpload id="file" value="#{uploadBean.uploadedFile}" required="true" />
        <h:message for="file" style="color: red;" />
      </div>
      <p>
      <div>
        <h:commandButton value="Incarca" action="#{uploadBean.uploadFile}" />
        <!--
        <h:commandButton value="Upload" action="uploadedfile" />
        
        <h:message for="uploadForm" infoStyle="color: green;" errorStyle="color: red;" />
        -->
       </div> 
       </p>
     </h:form>
     </f:view>
  </body>
</html>
