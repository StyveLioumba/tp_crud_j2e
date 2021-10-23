<%--
  Created by IntelliJ IDEA.
  User: styvelioumba
  Date: 23/10/2021
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <div class="card">
        <div class="card-header">
            Modification des produits
        </div>
    </div>
    <div class="card-body">
        <form action="update.do" method="post">
            <div hidden class="form-group">
                <label for="id">Identifiant : </label>
                <input type="text" name="id" id="id" class="form-control" value="${produit.id}"/>
            </div>
            <div class="form-group">
                <label for="nom">Nom du produit : </label>
                <input type="text" name="nom" id="nom" class="form-control" value="${produit.nom}"/>
            </div>
            <div class="form-group">
                <label for="prix">Prix : </label>
                <input type="text" name="prix" id="prix" class="form-control" value="${produit.prix}"/>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Modifier</button>
            </div>
        </form>
    </div>
</div>
<body>

</body>
</html>
