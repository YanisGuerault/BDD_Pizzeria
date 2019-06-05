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
    <title>Carte</title>
    <link rel="stylesheet" href="/css/Carte.css">
    <link href="js/Carte.js">
  </head>
  <body>

  <div class="wrap">
    <ul>
      <li><a href="racine.jsp">Accueil</a></li>
      <li><a href="carte.jsp">Carte</a></li>
      <li><a href="createcommande.jsp">Commande</a></li>
      <li><a href="fichelivraison.jsp">Livraison</a></li>
      <li><a href="createpizza.jsp">Pizza</a></li>
    </ul>

    <table>
      <c:forEach var="pizza" items="${ listPizza }">
      <tr>
        <td><span>${pizza[0].nom}</span></td>
        <td><span>${pizza[0].prix}</span></td>
      </tr>
      </c:forEach>
    </table>

    <!--<div class="table">
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
    </div>-->
  </div>
  </body>
</html>
