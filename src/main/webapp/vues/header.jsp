
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  header avec la barre de menus -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${param.pageTitle}</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Feuille CSS AJOUTEE  -->
<spring:url value="/resources/css/pageHeader.css" var="pageHeaderCSS" />
<link href="${pageHeaderCSS}" rel="stylesheet" />

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>



</head>

<body>

	<div class="container" id="container">
		<nav class="navbar navbar-default">
		  <div class="container-fluid" id="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">


				<!-- Liens de navigation du site -->
				<ul class="nav navbar-nav">
					<li role="presentation"><a
						href="http://localhost:8080/NekoAtsume/index">Home</a></li>
					<li role="presentation"><a
						href="http://localhost:8080/NekoAtsume/chats">Chats</a></li>
					<li role="presentation"><a
						href="http://localhost:8080/NekoAtsume/astuces">Astuces</a></li>
					<li role="presentation"><a
						href="http://localhost:8080/NekoAtsume/objets">Objets</a></li>
					
									</ul>
				
				
								<c:if test="${not empty param.Admin}">
<div class="col-md-2"></div>
					<div class="col-md-2">
						<div class="btn-group">
							<button data-toggle="dropdown"
								class="btn navbar-btn dropdown-toggle btn-danger" id="">
								Panneau d'administration <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="http://localhost:8080/NekoAtsume/AdminChats">Chats</a></li>
								<li><a href="http://localhost:8080/NekoAtsume/AdminAstuces">Astuces</a></li>
								<li><a href="http://localhost:8080/NekoAtsume/AdminMembres">Membres</a></li>
			
							</ul>
						</div>
					</div>

				</c:if>



				<c:if test="${not empty param.emailUser}">
					<div class="col-md-2"></div>
					<div class="col-md-2"></div>
					<div class="col-md-2">
						<a href="http://localhost:8080/NekoAtsume/monProfil"
							class="btn  navbar-btn btn-primary navbar-right" role="button">Mon
							profil</a>
					</div>
					<div class="col-md-2">
						<a href="http://localhost:8080/NekoAtsume/deconnexion"
							class="btn navbar-btn btn-danger navbar-right " role="button"
							id="Bouton1">Deconnexion</a>
					</div>
				</c:if>

				<!--   Si on est pas connecté -->
				<c:if test="${empty param.emailUser}">
					<div class="col-md-2"></div>
					<div class="col-md-2"></div>

					<div class="col-md-2">
						<a href="http://localhost:8080/NekoAtsume/compte"
							class="btn btn-default navbar-btn btn-primary navbar-right"
							role="button">Inscription</a>
					</div>
					<div class="col-md-2">
						<a href="http://localhost:8080/NekoAtsume/connexion"
							class="btn btn-default navbar-btn navbar-right " role="button"
							id="Bouton1">Connexion</a>
					</div>

				</c:if>



			</div>
		</div>
		</nav>
		
		<div class="page-header">
			<h1>${param.pageHeader}</h1>
		</div>
		<div>