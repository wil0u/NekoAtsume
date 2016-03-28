<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Panneau Administrateur Chats" />
   <jsp:param name="pageTitle" value="Panneau Administrateur" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
 <table  class="table table-striped">
 <a href="http://localhost:8080/NekoAtsume/AdminPanneau" class="btn btn-default" role="button">Revenir au Panneau d'administration</a>
 <br />
<BR>

<!-- Lorsqu'on a ajouté ou modifié avec succès, retour ici avec affichage  -->

<c:if test="${not empty Succes}">
<div class="alert alert-success">${Succes}</div>
 </c:if>
  
 <form method="post" action="/NekoAtsume/chat/chatsRech">          
Chercher un chat par son nom <input type="text" name="NomChat" value=""  />
Chercher un chat par son niveau <input type="text" name="LvlChat" value="" />
<button type="submit" class="btn btn-default">Rechercher le chat</button>
</form>

<a href="http://localhost:8080/NekoAtsume/AdminChats"><button class="btn btn-default">Afficher tous les chats</button></a>
<a href="http://localhost:8080/NekoAtsume/AdminAjoutChat"><button class="btn btn-default">Ajouter un Chat</button></a>
<br />
<BR>

  <tr>
    <th>Nom chat</th>
    <th>Image chat</th>
    <th>Power Lv.</th>
	<th></th>
	<th></th>
  </tr>
  <c:forEach var="chat" items="${listChat}">
  <tr>
    <td>${chat.nomChat}</td>
    <td><img src="${chat.cheminPhotoChat}" class="img-rounded" /></td>
    <td	>${chat.lvlChat}</td>
    <td><a href="http://localhost:8080/NekoAtsume/chat/${chat.idChat}/moderer">Modérer</a></td>
  </tr>
  </c:forEach>
</table> 
 
<%@ include file="footer.jsp" %>