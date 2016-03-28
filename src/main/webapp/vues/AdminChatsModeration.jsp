<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Detail du chat : ${Chat.nomChat } " />
   <jsp:param name="pageTitle" value="Détail chat" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
 <a href="http://localhost:8080/NekoAtsume/AdminChats" class="btn btn-default" role="button">Revenir au Panneau d'administration des Chats</a>
<br />
<br>
<form method="post" action="">
		<ul class="list-group" >
		
			<li class="list-group-item" >
			<span class="label label-default">Identifiant</span>
				${Chat.idChat }
				
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Nom</span>
				<input type="text" name="NomChat" value="${Chat.nomChat }"  />
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Image</span>
				<img src="${Chat.cheminPhotoChat}" />
			</li>
				<li class="list-group-item">
				<span class="label label-default">Couleur</span>
				<input type="text" name="NomChat" value="${Chat.couleurChat }" />
				
			</li >
		
			<li class="list-group-item">
			<span class="label label-default">Caractère</span>
				<input type="text" name="NomChat" value="${Chat.caractereChat }"/>
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Momento</span>
				<input type="text" name="NomChat" value="${Chat.memorialChat }"/>
			</li>
			
			<li class="list-group-item">
			<span class="label label-default">Nom japonnais</span>
			<input type="text" name="NomChat" value="	${Chat.nomJaponnaisChat } "/>
			</li>			
		</ul>
		
		<input type="submit" value="Modifier le Chat" class="btn btn-danger" />
		<div class="bouton_Supprimer"><a href="" class="btn btn-danger" role="bouton_Supprimer">Supprimer le Chat</a></div>
		</fieldset>
	</form>
	
	
<c:choose>
    <c:when test="${empty ListeAstuces}">
         <h2>${Chat.nomChat } n'a pas d'astuce. </h2>
    </c:when>
    <c:otherwise>
       <a href="http://localhost:8080/NekoAtsume/chat/${Chat.idChat}/astuces">Voir astuce(s) sur ce chat</a>

    </c:otherwise>
</c:choose>


<%@ include file="footer.jsp" %>


