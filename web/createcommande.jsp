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
<form method="post" action="CreateCommande">
    <legend><span class="number">1</span> Ajout des Commandes</legend>
    <input type="date" id="date_livraison" name="date_livraison" placeholder="Date de livraison"></input>
    <input type="time" id="temps_livraison" name="temps_livraison" placeholder="Temps de livraison"></input>
    <input type="number" id="prix" name="prix" placeholder="Prix"></input>

    <select id="livreur" name="livreur">
    <c:forEach var="livreur" items="${livreurs}">
        <option value="${livreur.id}">${livreur.nom} ${livreur.prenom}</option>
    </c:forEach>
    </select>

    <select id="vehicule" name="vehicule">
        <c:forEach var="vehicule" items="${vehicules}">
            <option value="${vehicule.id}">${vehicule.typeVehicule.libelle} ${vehicule.plaque}</option>
        </c:forEach>
    </select>

    <select id="client" name="client">
        <c:forEach var="client" items="${clients}">
            <option value="${client.id}">${client.nom} ${client.prenom}</option>
        </c:forEach>
    </select>

    <select id="pizza" name="pizza" multiple>
        <c:forEach var="pizza" items="${pizzas}">
            <option value="${pizza.id}">${pizza.nom}</option>
        </c:forEach>
    </select>
    <button type="submit">Envoyer</button>
</form>
</body>
</html>
