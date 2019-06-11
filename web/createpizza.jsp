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
        <form method="post" action="CreatePizza">

            <legend>Ajout des Pizza en BDD</legend>

            <input type="text" id="pizzaname" name="pizzaname" placeholder="Le nom de la pizza">
            <input type="number" id="prix" name="prix" placeholder="Prix">
        </br>
            <div class="ingredient">
            <c:forEach var="ingredient" items="${ingredients}">
                </br>
                        <div>
                            <input type="checkbox" id="${ingredient.nom}" name="ingredients" style="display: none;" value="${ingredient.nom}"/>
                            <label for="${ingredient.nom}" class="toggle"><span></span><span style="left: 40px;"> ${ingredient.nom}</span></label></br>
                        </div>
                </br>
            </c:forEach>
            </div>
            </br>
            <button type="submit" class="button">Envoyer</button>

        </form>
        </div>
    </body>
</html>
