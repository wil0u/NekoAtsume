<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Detail du chat : ${Chat.nomChat } " />
   <jsp:param name="pageTitle" value="D�tail chat" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
<a href="http://localhost:8080/NekoAtsume/chats"><button class="btn btn-primary">Revenir � l'affichage de tous les chats</button></a>
<br />
<br><!--  affiche les infos d'un chat -->

		<ul class="list-group" >
		
			<li class="list-group-item" >
			<span class="label label-default">Identifiant</span>
				${Chat.idChat }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Nom</span>
				${Chat.nomChat }
			</li>
		
			<li class="list-group-item">
			<div class="zoom">
			<span class="label label-default">Image</span>
				<img src="${Chat.cheminPhotoChat}" /></div>
			</li>
				<li class="list-group-item">
				<span class="label label-default">Couleur</span>
				${Chat.couleurChat }
			</li >
		
			<li class="list-group-item">
			<span class="label label-default">Caract�re</span>
				${Chat.caractereChat }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Momento</span>
				${Chat.memorialChat }
			</li>
			
			<li class="list-group-item">
			<span class="label label-default">Nom japonnais</span>
				${Chat.nomJaponnaisChat }
			</li>			
		</ul>
		<a class="btn btn-primary"  href="http://localhost:8080/NekoAtsume/chat/${Chat.idChat}/astuce">Ajouter une astuce</a>

<c:choose>

	<c:when test="${empty ListeAstuces}">
         ${Chat.nomChat } n'a pas d'astuce.
    </c:when>
    
	<c:otherwise>
		<a class="btn btn-primary" id="bouton1"
			href="http://localhost:8080/NekoAtsume/chat/${Chat.idChat}/astuces">Voir
			astuce(s) sur ce chat</a>

	</c:otherwise>
</c:choose>


<%@ include file="footer.jsp"%>
<!-- <a href="http://localhost:8080/NekoAtsume/chats"><button class="btn btn-default " id="bouton1">Afficher tous les chats</button></a> -->

