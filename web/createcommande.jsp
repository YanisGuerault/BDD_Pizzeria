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
    <link rel="stylesheet" type="text/css" href="css/create-pizza.css" />
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
<div class="formulaire">
<form method="post" action="CreateCommande">
    <legend>Ajout des Commandes</legend>

    <input type="date" id="date_livraison" name="date_livraison" placeholder="Date de livraison">
    <input type="time" id="temps_livraison" name="temps_livraison" placeholder="Temps de livraison">
    <input type="number" id="prix" name="prix" placeholder="Prix">

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

    <div class="ingredient">
        <c:forEach var="pizza" items="${pizzas}">
        </br>
        <div>
            <input type="checkbox" id="${pizza.id}" style="display: none" name="pizza" value="${pizza.id}"/>
            <label for="${pizza.id}" class="toggle"><span class="spann"></span><span style="left: 40px;">${pizza.nom}</span></label>
        </div>
        </br>
        </c:forEach>
    </div>
    <!--<select id="pizza" name="pizza" multiple="multiple">
        <c:forEach var="pizza" items="${pizzas}">
            <option value="${pizza.id}">${pizza.nom}</option>
        </c:forEach>
    </select>-->
    </br>
    <button type="submit" class="button">Envoyer</button>
</form>
</div>
</body>
</html>
