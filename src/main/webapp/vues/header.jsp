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



</head>

<body>
 <div class="row">
  </div>
 
 <div class="container" id="container">
 <nav class="navbar navbar-default">
  <div class="container-fluid" id= "container-fluid">
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
 <div class="container-fluid">
    <!-- Collect the nav links, forms, and other content for toggling -->
      <ul class="nav navbar-nav">
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/index">Home</a></li>
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/chats">Chats</a></li>
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/astuces">Astuces</a></li>
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/objets">Objets</a></li>
  
  
  <c:if test="${empty param.emailUser}">
  
<a href="http://localhost:8080/NekoAtsume/connexion" class="btn btn-default navbar-btn navbar-right " role="button" id="Bouton1">Connexion</a>
<a href="http://localhost:8080/NekoAtsume/compte" class="btn btn-default navbar-btn btn-primary navbar-right" role="button" id="Bouton2">Inscription</a>

</c:if>
</ul>
<c:if test="${not empty param.emailUser}">

    <a href="http://localhost:8080/NekoAtsume/deconnexion" class="btn navbar-btn navbar-right btn-danger" role="button">Deconnexion</a>
    <a href="http://localhost:8080/NekoAtsume/monProfil" class="btn  navbar-btn btn-danger navbar-right" role="button">Mon profil</a>
    
    <li class="dropdown navbar-right" >    
    <a class="btn navbar-btn navbar-right btn-danger" data-toggle="dropdown" href="#" >Panneau d'administration
        <span class="caret"></span></a>
        
        <ul class="dropdown-menu" >
          <li><a href="http://localhost:8080/NekoAtsume/AdminChats">Chats</a></li>
          <li><a href="http://localhost:8080/NekoAtsume/AdminAstuces">Astuces</a></li>
          <li><a href="http://localhost:8080/NekoAtsume/AdminMembres">Membres</a></li>
          
        </ul>
        </li>
        

    
</c:if>


  
  </div> 
  </div>
</nav>
    <div class="page-header">
      <h1>${param.pageHeader}</h1>
    </div>
    <div>
        
   
   
     
   