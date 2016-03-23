<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
      <h1>Detail de l'astuce : ${Astuce.titre }</h1>
    </div>

		<ul>
			<li>
				${Astuce.idAstuce }
			</li>
		
			<li>
				${Astuce.titre }
			</li>
		
			<li>
				${Astuce.categorie.nomCategorie }
			</li>
				<li>
				${Astuce.astuce }
			</li>
		
			<li>
				${Astuce.auteur.pseudo }
			</li>
		
			<li> Objets associés :
				<ul>
					<c:forEach var="objet" items="${Astuce.listObjet}">
						<li>${objet.nomObjet}
					</c:forEach>
				</ul>
			</li>
			<c:if test="${not empty Astuce.chat}">
   				<li>
					${Astuce.chat.nomChat }
				</li>	
			</c:if>		
		</ul>
 </div>
</body>
</html>