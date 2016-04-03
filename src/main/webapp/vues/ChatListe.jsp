<%@ include file="headerTag.jsp"%>

<jsp:include page="/vues/header.jsp">
	<jsp:param name="pageTitle" value="Liste chat" />
	<jsp:param name="pageHeader" value="Liste des chats" />
	<jsp:param name="emailUser" value="${emailUser }" />
	<jsp:param name="Admin" value="${Admin}" />
</jsp:include>
<table class="table table-striped">
<!-- affichage de la liste des chats -->

	<!--  affichera l'erreur si pas trouvé de chat au nom ou au niveau associé -->
	<div class="text-danger">${error}</div>

	<form method="post" action="/NekoAtsume/chat/chatsRech">
		Chercher un chat par son nom ou par son niveau <input type="text"
			name="RechChat" value="" />
		<button type="submit" class="btn btn-primary" id="bouton2">Rechercher
			le chat</button>
	</form>


	<a href="http://localhost:8080/NekoAtsume/chats"><button
			class="btn btn-primary " id="bouton1">Afficher tous les
			chats</button></a>
			<a href="http://localhost:8080/NekoAtsume/restChats" class="btn btn-primary " id="bouton2">Chats en json!</a>
	<div class="ligne"></div>


	<tr>
		<th>Nom chat <!--     Ordonnancement des chats par ASC ou DESC -->
			<a href="http://localhost:8080/NekoAtsume/chatsNomUP">
				<button type="button" class="btn btn-default"
					aria-label="Left Align">
					<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
				</button>
		</a> <a href="http://localhost:8080/NekoAtsume/chatsNomDOWN">
				<button type="button" class="btn btn-default"
					aria-label="Left Align">
					<span class="glyphicon glyphicon-triangle-bottom"
						aria-hidden="true"></span>
				</button>
		</a>
		</th>
		<th>Image chat</th>
		<th>Power Lv. <a
			href="http://localhost:8080/NekoAtsume/chatsLvlUP">
				<button type="button" class="btn btn-default"
					aria-label="Left Align">
					<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
				</button>
		</a> <a href="http://localhost:8080/NekoAtsume/chatsLvlDOWN">
				<button type="button" class="btn btn-default"
					aria-label="Left Align">
					<span class="glyphicon glyphicon-triangle-bottom"
						aria-hidden="true"></span>
				</button>
		</a>
		</th>
		
		<th>Ajouter une astuce</th>
	</tr>
	<c:forEach var="chat" items="${listChat}">
		<tr>
			<td><a
				href="http://localhost:8080/NekoAtsume/chat/${chat.idChat}">${chat.nomChat}</a></td>
			<td><img src="${chat.cheminPhotoChat}" class="img-rounded" /></td>
			<td>${chat.lvlChat}</td>
			
			<td><a
				href="http://localhost:8080/NekoAtsume/chat/${chat.idChat}/astuce" class="btn btn-primary" role="button" >Ajouter
					une astuce</a></td>
		</tr>
	</c:forEach>
</table>


<%@ include file="footer.jsp"%>
