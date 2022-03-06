<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
  <head>
    <title>File Upload</title>
  </head>
  <body>
    <h1>File Upload</h1>
    <h2>User Agent: ${userAgent}</h2>
    <h2>Session ID: ${sessionId}</h2>
    <form:form modelAttribute="fileUploadForm" enctype="multipart/form-data">
      <p>File</p>
      <form:input path="file" type="file" />
      <form:errors path="file" />
      <form:button>Submit</form:button>
    </form:form>
  </body>
</html>
