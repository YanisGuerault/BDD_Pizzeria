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
      <link rel="stylesheet" type="text/css" href="css/Carte.css" />
      <link rel="stylesheet" type="text/css" href="css/navbar.css" />
  </head>
  <body>

    <div class="ribbon">
      <a href="index"><span>Accueil</span></a>
      <a href="Carte" class="active"><span>Carte</span></a>
      <a href="CreateCommande"><span>Commande</span></a>
      <a href="FicheLivraison"><span>Livraison</span></a>
      <a href="CreatePizza"><span>Pizza</span></a>
    </div>

      <div class ="menu-body">
          <div class="menu-section">
            <h2 class="menu-section-title">PIZZAS</h2>
            <div class="menu-item">
              <c:forEach var="pizza" items="${ listPizza }">
              <div class="menu-item-name">
                  <span>${pizza[0].nom}</span>
              </div>

              <div class="menu-item-price">
                  <span>${pizza[0].prix}€</span>
              </div>

              <div class="menu-item-description">
                  <c:forEach var="ingredient" items="${ pizza[1] }">
                      ${ingredient.nom}
                  </c:forEach>
              </div>
              </br>
                </c:forEach>
            </div>
          </div>
      </div>
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