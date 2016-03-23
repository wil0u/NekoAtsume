<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détail Chat</title>

<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;    
}
</style>
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
<c:choose>
    <c:when test="${empty ListeAstuces}">
         <h2>Il n'y a pas d'astuce associée a ${Chat.nomChat } : </h2>
    </c:when>
    <c:otherwise>
       <h2>Liste des astuces associées a ${Chat.nomChat } : </h2>
<table style="width:100%">
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

</body>
</html>