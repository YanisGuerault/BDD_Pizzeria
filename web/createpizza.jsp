<%--
  Created by IntelliJ IDEA.
  User: QWWR3655
  Date: 24/04/2019
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Créer vos pizzas</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css" />
    <link rel="stylesheet" type="text/css" href="css/create-pizza.css" />
</head>
<body>
<div class=""navbar">
<ul>
    <li><a href="Carte">Carte</a></li>
    <li><a href="CreateCommande">Commande</a></li>
    <li><a href="FicheLivraison">Livraison</a></li>
    <li><a href="CreatePizza">Pizza</a></li>
</ul>
</div>
<form method="post" action="CreatePizza">
    <legend><span class="number">1</span> Ajout des Pizza en BDD</legend>
    <input type="text" id="pizzaname" name="pizzaname" placeholder="Le nom de la pizza"></input>
    <input type="number" id="prix" name="prix" placeholder="Prix"></input>
    <c:forEach var="ingredient" items="${ingredients}">
        <div class="pretty p-default">
            <input type="checkbox" name="ingredients" value="${ingredient.nom}"/>
            <div class="state p-success">
                <label>${ingredient.nom}</label>
            </div>
        </div>
        <br>
    </c:forEach>
    <button type="submit">Envoyer</button>
</form>
</body>
</html>
