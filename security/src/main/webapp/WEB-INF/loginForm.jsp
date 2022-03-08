<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>

<DOCTYPE html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <div id="wrapper">
      <h1>Login</h1>
      <c:if test="${param.containsKey('error')}">
        <p>Out</p>
        <span style="color: red;">
          <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
        </span>
      </c:if>
      <c:url var="loginUrl" value="/login" />
      <form:form action="loginUrl">
        <table>
          <tr>
            <td><label for="username">Username</td>
            <td><input type="text" id="username" name="username"></td>
          </tr>
          <tr>
            <td><label for="password">Password</td>
            <td><input type="password" id="password" name="password"></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><button>Login</button></td>
          </tr>
        </table>
      </form:form>
    </div>
  </body>
</html>
