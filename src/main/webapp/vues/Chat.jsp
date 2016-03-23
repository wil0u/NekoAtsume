<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détail Chat</title>
</head>
<body>

		<ul>
			<li>
				${Chat.idChat }
			</li>
		
			<li>
				${Chat.nomChat }
			</li>
		
			<li>
				${Chat.cheminPhotoChat }
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

<h2>Liste des astuces associées : </h2>
		<ul>
			<c:forEach var="astuce" items="${ListeAstuces}">
				<li>${astuce.astuce}------<a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}">Détail</a></li>
			</c:forEach>
		</ul>

</body>
</html>