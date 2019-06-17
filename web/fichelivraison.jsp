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
  <form method="post" action="FicheLivraison">

    <legend>Export des fiches de livraisons</legend>

    <select id="fiche_livraison" name="fiche_livraison" onchange="OnChange()">
      <c:forEach var="commande" items="${ commandList }">
        <option value="${commande.id}">${commande.dateLivraison}</option>
      </c:forEach>
    </select>

    <button type="submit" class="button">Valider</button>

    </br></br>
    <label>Date Livraison : ${commande.dateLivraison}</label>
    </br></br>
    <label>Prix Commande : ${commande.prix}</label>
    </br></br>
    <label>Pizza : </label>
    <c:forEach var="pizza" items="${ commande.listPizza }">
      <label>${pizza.nom}</label>
    </c:forEach>
    </br></br>
    <label>Temps Livraison : ${commande.tempsLivraison}</label>
    </br></br>
    <label>Client : ${commande.client.nom} ${commande.client.prenom}</label>
    </br></br>
    <label>Livreur : ${commande.livreur.nom} ${commande.livreur.prenom}</label>
    </br></br>
    <label>Type Véhicule : ${commande.vehicule.typeVehicule.libelle}</label>
    </br></br>
    <label>Véhicule : ${commande.vehicule.plaque}</label>
    </br></br>

  </form>

  </div>

</body>

</html>
