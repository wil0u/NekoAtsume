    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détail Chat</title>

 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>
 <div class="container">
    <div class="page-header">
      <h1>Détail du chat : ${Chat.nomChat }</h1>
    </div>
		<ul >
			<li>
				${Chat.idChat }
			</li>
		
			<li>
				${Chat.nomChat }
			</li>
		
			<li>
				<img src="${Chat.cheminPhotoChat}" />
			</li>
				<li>
				${Chat.couleurChat }
			</li>
		
			<li>
				${Chat.caractereChat }
			</li>
		
			<li>
				${Chat.memorialChat }
			</li>
			
			<li>
				${Chat.nomJaponnaisChat }
			</li>			
		</ul>

<c:choose>
    <c:when test="${empty ListeAstuces}">
         <h2>${Chat.nomChat } n'a pas d'astuce. </h2>
    </c:when>
    <c:otherwise>
       <h2>Liste des astuces associées a ${Chat.nomChat } : </h2>
<table class="table table-hover">
  <tr>
    <th>Titre</th>
    <th>Lien</th>
  </tr>
  <c:forEach var="astuce" items="${ListeAstuces}">
  <tr>
    <td>${astuce.titre}</td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}">Détail</a></td>
  </tr>
  </c:forEach>
</table> 
    </c:otherwise>
</c:choose>
</div>
</body>
</html>