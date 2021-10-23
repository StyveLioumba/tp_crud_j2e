<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: styvelioumba
  Date: 23/10/2021
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
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
            Saisie des produits
        </div>
    </div>
    <div class="card-body">
        <form action="save.do" method="post">
            <div class="form-group mb-2">
                <label for="nom">Nom du produit : </label>
                <input type="text" name="nom" id="nom" class="form-control">
            </div>
            <div class="form-group mb-2">
                <label for="prix">Prix : </label>
                <input type="text" name="prix" id="prix" class="form-control">
            </div>
            <div class="mb-2">
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </div>
        </form>
    </div>
</div>
<body>

</body>
</html>
