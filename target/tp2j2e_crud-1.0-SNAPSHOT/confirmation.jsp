<%--
  Created by IntelliJ IDEA.
  User: styvelioumba
  Date: 23/10/2021
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Confirmation</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="header.jsp"%>

<div class="container">
    <div class="card">
        <div class="card-header">
            Confirmation Ajout Produit
        </div>
        <div class="card-body">
            <div class="form-group">
                <label for="id">Identifiant : </label>
                <input type="text" name="id" value="${produit.id}" id="id">
            </div>
            <div class="form-group">
                <label for="nom">Nom du produit : </label>
                <input type="text" name="nom" value="${produit.nom}" id="nom">
            </div>
            <div class="form-group">
                <label for="prix">Prix : </label>
                <input type="text" name="prix" value="${produit.prix}" id="prix">
            </div>
        </div>
    </div>
</div>

</body>
</html>
