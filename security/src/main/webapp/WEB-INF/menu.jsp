<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>

<DOCTYPE html>
  <head>
    <title>Menu</title>
  </head>
  <body>
    <div id="wrapper">
      <h1>Menu</h1>
      <p><sec:authentication property="principal.user.username" /></p>
      <p><c:out value="${user.username}" /></p>
      <form action="<c:url value='/logout' />" method="POST">
        <sec:csrfInput />
        <button>Logout</button>
      </form>
    </div>
  </body>
</html>
