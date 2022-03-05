<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Echo/Output</title>
  </head>
  <body>
    <h1>Input Text</h1>
    <p><c:out value="${echoForm.text}" /></p>
    <a href="<c:url value='/' />">Top</a>
  </body>
</html>