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
</head>
<body>
<form method="post" action="CreatePizza">
    <input type="text" id="pizzaname" name="pizzaname" placeholder="Le nom de la pizza"></input>
    <input type="number" id="prix" name="prix" placeholder="Prix"></input>
    <select name="ingredients" multiple>
        <c:forEach var="ingredient" items="${ingredients}">
            <option value="${ingredient.nom}">${ingredient.nom}</option>
        </c:forEach>
    </select>
    <button type="submit">Envoyer</button>
</form>
</body>
</html>
