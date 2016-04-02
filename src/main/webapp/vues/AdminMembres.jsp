 <%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Panneau d'administration des Membres" />
   <jsp:param name="pageTitle" value="Panneau d'administration des Chats" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
 <table  class="table table-striped">
<table  class="table table-striped">
 
 <!-- Lorsqu'on a banni avec succès, retour ici avec affichage  -->

<c:if test="${not empty Succes}">
<div class="alert alert-success">${Succes}</div>
 </c:if>
 

 <form method="post" action="/NekoAtsume/membre/membreRech">          
Chercher un membre par son nom <input type="text" name="NomChat" value=""  />
Chercher un membre par son email <input type="text" name="LvlChat" value="" />
<button type="submit" class="btn btn btn-primary">Rechercher le membre</button>
</form>
  
<a href="http://localhost:8080/NekoAtsume/AdminMembres" class="btn btn-primary" role="button">Afficher tous les membres</a>

  <tr>
    <th>Nom membre</th>
    <th>Email Membre</th>
   	<th>Etat du joueur</th>	
  </tr>
  <c:forEach var="inscrit" items="${listInscrit}">
  <tr>
    <td>${inscrit.pseudo}</td>
     <td>${inscrit.email}</td>

     <c:if test="${not inscrit.banned}"><td><a href="http://localhost:8080/NekoAtsume/membre/${inscrit.compteId}/bannir" class="btn btn-primary" role="button">Non banni</a></td></c:if>
    <c:if test="${inscrit.banned}"><td><a href="http://localhost:8080/NekoAtsume/membre/${inscrit.compteId}/debannir" class="btn btn-danger" role="button">Banni</a></td></c:if>
   		
  </tr>
  </c:forEach>
</table> 
 <%@ include file="footer.jsp" %>