<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<DOCTYPE html>
  <head>
    <title>Creation</title>
  </head>
  <body>
    <h1>Form</h1>
    <form:form modelAttribute="accountCreateForm">
      <p>Name</p>
      <form:input path="name" />
      <form:errors path="name" />
      <p>Email</p>
      <form:input path="email" />
      <form:errors path="email" />
      <form:button>Submit</form:button>
    </form:form>
  </body>
</html>
