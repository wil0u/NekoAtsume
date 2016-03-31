<%@ include file="headerTag.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Detail du chat : ${Chat.nomChat } " />
   <jsp:param name="pageTitle" value="Détail chat" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
 <a href="http://localhost:8080/NekoAtsume/AdminChats" class="btn btn-default" role="button">Revenir au Panneau d'administration</a>
<br />
<br>

<form method="post" action="/NekoAtsume/modifierChat" accept-charset="ISO-8859-1">
<form:errors path="*" />

		<ul class="list-group" >
		
			<li class="list-group-item" >
			<span class="label label-default">Identifiant</span>
			<input type="hidden" name="idChat" value="${Chat.idChat }"  />
				${Chat.idChat }
				
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Nom</span>
				<input type="text" name="nomChat" value="${Chat.nomChat }"  />
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Image</span>
				<img src="${Chat.cheminPhotoChat}" />
			</li>
				<li class="list-group-item">
				<span class="label label-default">Couleur</span>
				<input type="text" name="couleurChat" value="${Chat.couleurChat }" />
				
			</li >
		
			<li class="list-group-item">
			<span class="label label-default">Caractère</span>
				<input type="text" name="caractereChat" value="${Chat.caractereChat }"/>
			</li>
				<li class="list-group-item">
			<span class="label label-default">Lv. chat</span>
				<input type="text" name="lvlChat" value="${Chat.lvlChat }"/>
			</li>
			<li class="list-group-item">
			<span class="label label-default">Momento</span>
				<input type="text" name="memorialChat" value="${Chat.memorialChat }"/>
			</li>
			
			<li class="list-group-item">
			<span class="label label-default">Nom japonnais</span>
			<input type="text" name="nomJaponnaisChat" value="${Chat.nomJaponnaisChat }"/>
			</li>			
		</ul>
		
		<input type="submit" value="Modifier le Chat" class="btn btn-danger" />
		</form>
		<c:choose>
    <c:when test="${empty ListeAstuces}">
         <h2>${Chat.nomChat } n'a pas d'astuce. </h2>
    </c:when>
    <c:otherwise>
       <div class="bouton_Showr"> <a class="btn btn-default"  href="http://localhost:8080/NekoAtsume/chat/${Chat.idChat}/astuces">Voir astuce(s) sur ce chat</a></div>
</c:otherwise>
    </c:choose>
		<form method="post" action="/NekoAtsume/supprimerChat"  accept-charset="ISO-8859-1">
		<input type="hidden" name="idChat" value="${Chat.idChat }"  />
		<input type="submit" value="Supprimer le chat" class="btn btn-danger" />
		</fieldset>

	
	



<%@ include file="footer.jsp" %>


