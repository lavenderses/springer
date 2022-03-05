<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Echo/Input</title>
  </head>
  <body>
    <h1>Form</h1>
    <form:form modelAttribute="echoForm">
      <p>Input text below.</p>
      <form:input path="text" />
      <form:errors path="text" />
      <form:button>Submit</form:button>
    </form:form>
  </body>
</html>