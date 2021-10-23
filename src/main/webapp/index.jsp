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
            Recherche des Produits
        </div>
    </div>
    <div class="card-body">
        <form action="search.do" method="get">
            <input type="text" name="keyword" value="${modele.keyword}" id="keyword">
            <button type="submit" class="btn btn-primary">rechercher</button>
        </form>
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>NOM</th>
                <th>PRIX</th>
            </tr>
            <c:forEach items="${modele.produits}" var="produit">
                <tr>
                    <td>${produit.id}</td>
                    <td>${produit.nom}</td>
                    <td>${produit.prix}</td>
                    <td>
                        <a onclick="return confirm('Etes-vous sur?')" href="supprimer.do?id=${produit.id}">
                            supprimer
                        </a>
                    </td>
                    <td>
                        <a href="editer.do?id=${produit.id}">Editer</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
