 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${param.pageTitle}</title>

 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>

 <div class="container">
 <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->


    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/index">Home</a></li>
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/chats">Chats</a></li>
  <li role="presentation"><a href="http://localhost:8080/NekoAtsume/astuces">Astuces</a></li>
  <c:if test="${empty param.emailUser}">
<p class="navbar-text navbar-right"><a href="http://localhost:8080/NekoAtsume/connexion" class="navbar-link">Connexion</a></p>
<p class="navbar-text navbar-right"><a href="http://localhost:8080/NekoAtsume/compte" class="navbar-link">Inscription</a></p>
</c:if>
<c:if test="${not empty param.emailUser}">
    <p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">${param.emailUser}</a></p>
    <p class="navbar-text navbar-right"><a href="http://localhost:8080/NekoAtsume/deconnexion" class="navbar-link">Log out</a></p>
</c:if>
  
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
    <div class="page-header">
      <h1>${param.pageHeader}</h1>
    </div>