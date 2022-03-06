<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval var="cart" expression="@cart" />
<DOCTYPE html>
  <head>
    <title>Carts Access</title>
  </head>
  <body>
    <h1>Top</h1>
    <p>Born in ${cart.born}</p>
    <p>Last access in an session: ${cart.lastAccess}</p>
  </body>
</html>
