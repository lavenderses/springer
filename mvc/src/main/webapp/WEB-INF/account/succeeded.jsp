<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Account Creation Succeeded</title>
  </head>
  <body>
    <h1>Succeeded</h1>
    <p>Name: <c:out value="${accountCreateForm.name}" /></p>
    <p>Tel: <c:out value="${accountCreateForm.tel}" /></p>
    <p>Birth Day: <c:out value="${accountCreateForm.dateOfBirth}" /></p>
    <p>Email: <c:out value="${accountCreateForm.email}" /></p>
    <p>Roles: <c:out value="${accountCreateForm.roles}" /></p>
    <p>Member Type: <c:out value="${accountCreateForm.card.type}" /></p>
    <p>Card Number: <c:out value="${accountCreateForm.card.cardNumber}" /></p>
    <p>Valid Month: <c:out value="${accountCreateForm.card.validMonth}" /></p>
  </body>
</html>