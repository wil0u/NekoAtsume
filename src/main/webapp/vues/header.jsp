 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${param.pageTitle}</title>

 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Feuille CSS AJOUTEE  -->
<spring:url value="/resources/css/pageHeader.css" var="pageHeaderCSS" />
<link href="${pageHeaderCSS}" rel="stylesheet" />

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<!-- Ajout image entête -->
<img src="http://localhost:8080/NekoAtsume/resources/imagesFond/nekoA.jpg" alt="ImageEntête">
</head>

<body>
 <div class="row">
  </div>
 
 <div class="container" id="container">
 <nav class="navbar navbar-default">
  <div class="container-fluid" id= "container-fluid">
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

    <!-- Collect the nav links, forms, and other content for toggling -->
      <ul class="nav navbar-nav">
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/index">Home</a></li>
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/chats">Chats</a></li>
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/astuces">Astuces</a></li>
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/objets">Objets</a></li>
  </ul>
  <c:if test="${empty param.emailUser}">
  
<a href="http://localhost:8080/NekoAtsume/connexion" class="btn btn-default navbar-btn navbar-right " role="button" id="Bouton1">Connexion</a>
<a href="http://localhost:8080/NekoAtsume/compte" class="btn btn-default navbar-btn btn-primary navbar-right" role="button" id="Bouton2">Inscription</a>

</c:if>
<c:if test="${not empty param.emailUser}">
    <p class="navbar-text navbar-right">Signed in as <a href="http://localhost:8080/NekoAtsume/monProfile" class="navbar-link">${param.emailUser}</a></p>
    <a href="http://localhost:8080/NekoAtsume/deconnexion" class="btn btn-default navbar-btn navbar-right btn btn-danger" role="button">Log out</a>
</c:if>

 <a href="http://localhost:8080/NekoAtsume/AdminPanneau" class="btn btn-default navbar-btn navbar-right btn btn-danger" role="button">Panneau d'administration</a>

  
  </div> 
  </div>
</nav>
    <div class="page-header">
      <h1>${param.pageHeader}</h1>
    </div>
