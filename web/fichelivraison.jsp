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
  <title>Fiche de livraison</title>
  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css" />
  <link rel="stylesheet" type="text/css" href="css/create-pizza.css" />
  <script src="js/fiche_livraison.js"></script>
</head>
<body>
<form method="post" action="FicheLivraison">
  <legend><span class="number">1</span> Export des fiches de livraisons</legend>
  <select id="fiche_livraison" name="fiche_livraison" onchange="OnChange()">
    <c:forEach var="commande" items="${ commandList }">
      <option value="${commande.id}">${commande.dateLivraison}</option>
    </c:forEach>
  </select>
  <button type="submit">Valider</button>
  <label>Date Livraison : ${commande.dateLivraison}</label>
  <label>Prix Commande : ${commande.prix}</label>
  <label>Pizza : </label>
  <c:forEach var="pizza" items="${ commande.listPizza }">
    <label>${pizza.nom}</label>
  </c:forEach>
  <label>Temps Livraison : ${commande.tempsLivraison}</label>
  <label>Client : ${commande.client.nom} ${commande.client.prenom}</label>
  <label>Livreur : ${commande.livreur.nom} ${commande.livreur.prenom}</label>
  <label>Type Véhicule : ${commande.vehicule.typeVehicule.libelle}</label>
  <label>Véhicule : ${commande.vehicule.plaque}</label>
</form>
</body>
</html>
