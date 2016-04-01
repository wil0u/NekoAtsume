<%@ include file="headerTag.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Ajouter un chat" />
   <jsp:param name="pageTitle" value="Ajouter un Chat" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
 <a href="http://localhost:8080/NekoAtsume/AdminChats" class="btn btn-default" role="button">Revenir au Panneau d'administration des Chats</a>
<div class="text-danger">${error1}
${error2}
${error3}
${error4}
${error5} </div>

<!-- A MODIFIER !!!! -->

<form method="post" action="/NekoAtsume/chat/AdminAjoutChat" accept-charset="ISO-8859-1">
<form:errors path="*" />

		<ul class="list-group" >
	
			<li class="list-group-item">
			<span class="label label-default">Nom</span>
				<input type="text" name="nomChat"   />
			</li>
	
				<li class="list-group-item">
				<span class="label label-default">Couleur</span>
				<input type="text" name="couleurChat"  />
				
			</li >
		
			<li class="list-group-item">
			<span class="label label-default">Caractère</span>
				<input type="text" name="caractereChat" />
			</li>
				<li class="list-group-item">
			<span class="label label-default">Lv. chat</span>
				<input type="text" name="lvlChat" />
			</li>
			<li class="list-group-item">
			<span class="label label-default">Momento</span>
				<input type="text" name="memorialChat"/>
			</li>
			
			<li class="list-group-item">
			<span class="label label-default">Nom japonnais</span>
			<input type="text" name="nomJaponnaisChat" />
			</li>			
		</ul>
		
		<input type="submit" value="Ajouter le chat" class="btn btn-danger" />
		</form>



<%@ include file="footer.jsp" %>