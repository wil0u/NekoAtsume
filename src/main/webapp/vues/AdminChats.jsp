 <%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Panneau d'administration" />
   <jsp:param name="pageTitle" value="Panneau d'administration des Chats" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
 <table  class="table table-striped">
<!-- Lorsqu'on a ajouté ou modifié avec succès, retour ici avec affichage  -->

<c:if test="${not empty Succes}">
<div class="alert alert-success">${Succes}</div>
 </c:if>
  
  Rechercher non fonctionnelle dans panneau admin // A modifier pour n'avoir qu'un seul champ</br>
 <form method="post" action="/NekoAtsume/chat/chatsRech">          
Chercher un chat par son nom <input type="text" name="NomChat" value=""  />
Chercher un chat par son niveau <input type="text" name="LvlChat" value="" />
<button type="submit" class="btn btn-default">Rechercher le chat</button>
</form>

<a href="http://localhost:8080/NekoAtsume/AdminChats"><button class="btn btn-default">Afficher tous les chats</button></a>
<a href="http://localhost:8080/NekoAtsume/AdminAjoutChat"><button class="btn btn-default">Ajouter un Chat</button></a>
<div class="ligne"></div>

  <tr>
    <th>Nom chat
<!--     Ordonnancement des chats par ASC ou DESC -->
    <a href="http://localhost:8080/NekoAtsume/AdminChatsNomUP">
    <button type="button" class="btn btn-default" aria-label="Left Align">
  <span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
</button>
</a>
 <a href="http://localhost:8080/NekoAtsume/AdminChatsNomDOWN">
<button type="button" class="btn btn-default" aria-label="Left Align">
  <span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
</button>
    </a>
    </th>
    <th>Image chat</th>
    <th>Power Lv.
    
     <a href="http://localhost:8080/NekoAtsume/AdminChatsLvlUP">
    <button type="button" class="btn btn-default" aria-label="Left Align">
  <span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
</button>
</a> <a href="http://localhost:8080/NekoAtsume/AdminChatsLvlDOWN">
    <button type="button" class="btn btn-default" aria-label="Left Align">
  <span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
</button>
</a>
     </th>
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