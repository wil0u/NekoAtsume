<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="D�tail de l'astuce : ${Astuce.titre } " />
   <jsp:param name="pageTitle" value="D�tail astuce" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
<a href="http://localhost:8080/NekoAtsume/AdminAstuces"><button class="btn btn-default">Revenir au Panneau d'administration des Astuces</button></a>
<br />
<br>
<form method="post" action="">

		<ul>
			<li class="list-group-item" >
			<span class="label label-default">Identifiant</span>
				${Astuce.idAstuce }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Titre</span>
				<input type="text" class="form-control" name="NomChat" value="${Astuce.titre }"/>
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Cat�gorie</span>
				<input type="text" placeholder="Cat�gorie" name="NomChat" value="${Astuce.categorie.nomCategorie }"/>
				//
				
				Penser � cr�er un champ gris� impossible � remplir si astuce concerne pas chat
				<input type="text" placeholder="Nom du chat si chat concern�" name="NomChat" value="<c:if test="${not empty Astuce.chat}">
   				
					${Astuce.chat.nomChat}
					
			</c:if>		"/>
			</li>
				<li class="list-group-item">
			<span class="label label-default">Astuce</span>
				<input type="text" name="NomChat" class="form-control" value="${Astuce.astuce }"/>
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Auteur</span>
				${Astuce.auteur.pseudo }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Objets associ�s</span>
						<ul>
					<c:forEach var="objet" items="${Astuce.listObjet}">
						<li>${objet.nomObjet}
					</c:forEach>
				</ul>
			</li>
			
		<input type="submit" value="Modifier l'astuce" class="btn btn-danger" />
		<div class="bouton_Supprimer"><a href="" class="btn btn-danger" role="bouton_Supprimer">Supprimer l'astuce</a></div>
			
		</ul>
		
		
<%@ include file="footer.jsp" %>