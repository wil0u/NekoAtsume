<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Détail de l'astuce : ${Astuce.titre } " />
   <jsp:param name="pageTitle" value="Détail astuce" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
<a href="http://localhost:8080/NekoAtsume/astuces"><button class="btn btn-default">Revenir à l'affichage des astuces</button></a>
<br />
<br>
<center>
		<ul>  <a href="http://localhost:8080/NekoAtsume/chatsNomUP">
    <button type="button" id = "votesPour" class="btn btn-default" aria-label="Left Align">
  <span class="glyphicon glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
</button>
</a>
 <a href="http://localhost:8080/NekoAtsume/chatsNomUP">
    <button type="button" id = "votesContre" class="btn btn-default" aria-label="Left Align">
  <span class="glyphicon glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>
</button>
</a> 
</center>
<div class="progress">
  <div class="progress-bar progress-bar-success" role="progressbar" style="width:70%">
    Nom de votes pour (% à renvoyer dans la barre)
  </div>
   <div class="progress-bar progress-bar-danger" role="progressbar" style="width:30%">
     Nom de votes contre (% à renvoyer dans la barre)
  </div>
</div>

		<ul>
			<li class="list-group-item" >
			<span class="label label-default">Identifiant</span>
				${Astuce.idAstuce }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Titre</span>
				${Astuce.titre }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Catégorie</span>
				${Astuce.categorie.nomCategorie }
				//
				<c:if test="${not empty Astuce.chat}">
   				
					${Astuce.chat.nomChat}
					
			</c:if>		
			</li>
				<li class="list-group-item">
			<span class="label label-default">Astuce</span>
				${Astuce.astuce }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Auteur</span>
				${Astuce.auteur.pseudo }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Objets associés</span>
						<ul>
					<c:forEach var="objet" items="${Astuce.listObjet}">
						<li>${objet.nomObjet}
					</c:forEach>
				</ul>
			</li>
			
			
		</ul>
		
		
<%@ include file="footer.jsp" %>