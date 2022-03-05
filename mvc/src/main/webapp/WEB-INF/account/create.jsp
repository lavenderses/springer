<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Account Creation</title>
  </head>
  <body>
    <h1>Form</h1>
    <form:form modelAttribute="accountCreateForm">
      <p>Name</p>
      <form:input path="name" />
      <form:errors path="name" />
      <p>Tel</p>
      <form:input path="tel" />
      <form:errors path="tel" />
      <p>Birth day</p>
      <form:input path="dateOfBirth" />
      <form:errors path="dateOfBirth" />
      <p>Email</p>
      <form:input path="email" />
      <form:errors path="email" />
      <p>Email confirmation</p>
      <form:input path="emailConfirmation" />
      <form:errors path="emailConfirmation" />
      <p>Roles</p>
      <form:checkbox path="roles" value="general" /> General
      <form:checkbox path="roles" value="supervisor" /> Supervisor
      <form:checkbox path="roles" value="admin" /> Admin
      <p>Members Type</p>
      <form:radiobutton path="card.type" label="Free" value="1" />
      <form:radiobutton path="card.type" label="Payment" value="2" />
      <form:errors path="card.type" />
      <p>Card number</p>
      <form:input path="card.cardNumber" />
      <form:errors path="card.cardNumber" />
      <p>Valid month</p>
      <form:input path="card.validMonth" />
      <form:errors path="card.validMonth" />
      <form:button>Submit</form:button>
    </form:form>
  </body>
</html>