<%--
  Created by IntelliJ IDEA.
  User: QWWR3655
  Date: 24/04/2019
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>PIZZA !</title>
  </head>
  <body>
  <c:forEach var="element" items="${listPizza}" varStatus="status">
    <p>${status.count}.${element.nom}</p><br>
  </c:forEach>
  </body>
</html>
