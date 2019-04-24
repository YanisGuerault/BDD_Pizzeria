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
    <link rel="stylesheet" type="text/css" href="css/edit-table.css" />
    <script type="text/javascript" src="js/edit-table.js"> </script>
  </head>
  <body>

  <div class="wrap">
    <div class="table">
      <ul>

        <c:forEach var="pizza" items="${ listPizza }">
        <li>
          <div class="top">
            <h1>${pizza[0].nom}</h1>
            <div class="circle">${pizza[0].prix}</div>
          </div>
          <div class="bottom">
          <c:forEach var="ingredient" items="${ pizza[1] }">
            <p>${ingredient.nom}</p>
          </c:forEach>
          </div>
        </li>
        </c:forEach>

      </ul>
    </div>
  </div>
  </body>
</html>
