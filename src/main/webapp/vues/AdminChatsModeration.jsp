<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Detail du chat : ${Chat.nomChat } " />
   <jsp:param name="pageTitle" value="Détail chat" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
 <a href="http://localhost:8080/NekoAtsume/AdminChats" class="btn btn-default" role="button">Revenir au Panneau d'administration</a>
<br />
<br>
<form method="post" action="/NekoAtsume/modifierChat">
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
		<c:choose>
    <c:when test="${empty ListeAstuces}">
         <h2>${Chat.nomChat } n'a pas d'astuce. </h2>
    </c:when>
    <c:otherwise>
       <div class="bouton_Showr"> <a class="btn btn-default"  href="http://localhost:8080/NekoAtsume/chat/${Chat.idChat}/astuces">Voir astuce(s) sur ce chat</a></div>
</c:otherwise>
    </c:choose>

		<div class="bouton_Supprimer"><a href="" class="btn btn-danger" role="bouton_Supprimer">Supprimer le Chat</a></div>
		</fieldset>
	</form>
	
	



<%@ include file="footer.jsp" %>


