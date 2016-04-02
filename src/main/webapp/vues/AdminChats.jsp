
<%@ include file="headerTag.jsp"%>

<jsp:include page="/vues/header.jsp">
	<jsp:param name="pageHeader" value="Panneau d'administration des Chats" />
	<jsp:param name="pageTitle" value="Panneau d'administration des Chats" />
	<jsp:param name="emailUser" value="${emailUser }" />
	<jsp:param name="Admin" value="${Admin}" />
</jsp:include>
<table class="table table-striped">
	<!-- Lorsqu'on a ajouté ou modifié avec succès, retour ici avec affichage  -->

	<c:if test="${not empty Succes}">
		<div class="alert alert-success">${Succes}</div>
	</c:if>
	<c:if test="${not empty Error}">
		<div class="alert alert-danger">${Error}</div>
	</c:if>
	
	<form method="post" action="/NekoAtsume/chat/AdminChatsRech">
		Chercher un chat par son nom ou par son niveau <input type="text"
			name="RechChat" value="" />
		<button type="submit" class="btn btn-primary" id="bouton2">Rechercher
			le chat</button>
	</form>


	<a href="http://localhost:8080/NekoAtsume/AdminAjoutChat"><button
			class="btn btn-primary" id="bouton2">Ajouter un Chat</button></a>
	<a href="http://localhost:8080/NekoAtsume/AdminChats"><button
			class="btn btn-primary" id="bouton1">Afficher tous les chats</button></a>
	<div class="ligne"></div>

	<tr>
		<th>Nom chat <!--     Ordonnancement des chats par ASC ou DESC -->
			<a href="http://localhost:8080/NekoAtsume/AdminChatsNomUP">
				<button type="button" class="btn btn-default"
					aria-label="Left Align">
					<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
				</button>
		</a> <a href="http://localhost:8080/NekoAtsume/AdminChatsNomDOWN">
				<button type="button" class="btn btn-default"
					aria-label="Left Align">
					<span class="glyphicon glyphicon-triangle-bottom"
						aria-hidden="true"></span>
				</button>
		</a>
		</th>
		<th>Image chat</th>
		<th>Power Lv. <a
			href="http://localhost:8080/NekoAtsume/AdminChatsLvlUP">
				<button type="button" class="btn btn-default"
					aria-label="Left Align">
					<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
				</button>
		</a> <a href="http://localhost:8080/NekoAtsume/AdminChatsLvlDOWN">
				<button type="button" class="btn btn-default"
					aria-label="Left Align">
					<span class="glyphicon glyphicon-triangle-bottom"
						aria-hidden="true"></span>
				</button>
		</a>
		</th>
		<th>Modération</th>
		<th>Suppression </th>
		
	</tr>
	<c:forEach var="chat" items="${listChat}">
		<tr>
			<td>${chat.nomChat}</td>
			<td><img src="${chat.cheminPhotoChat}" class="img-rounded" /></td>
			<td>${chat.lvlChat}</td>
			<td><a
				href="http://localhost:8080/NekoAtsume/chat/${chat.idChat}/moderer" class="btn btn-primary" role="button">Modérer</a></td>
				
				<td><a href="http://localhost:8080/NekoAtsume/chat/${chat.idChat}/supprimer" class="btn btn-danger" role="button">Supprimer</a>
					
				</td>
		</tr>
	</c:forEach>
</table>


<%@ include file="footer.jsp"%>