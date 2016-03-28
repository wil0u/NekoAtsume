<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Panneau d'Administration des Membres" />
   <jsp:param name="pageTitle" value="Panneau d'Administrations des membres" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
 <table  class="table table-striped">

 <a href="http://localhost:8080/NekoAtsume/AdminPanneau" class="btn btn-default" role="button">Revenir au Panneau d'administration</a>
  <h1> ATTENTION GROS PROBLEME DE SECURITE CAR ENVOI DES MDP SUR LE RESEAU</h1>
 
 <!-- Lorsqu'on a banni avec succès, retour ici avec affichage  -->

<c:if test="${not empty Succes}">
<div class="alert alert-success">${Succes}</div>
 </c:if>
 

 <form method="post" action="/NekoAtsume/membre/membreRech">          
Chercher un membre par son nom <input type="text" name="NomChat" value=""  />
Chercher un membre par son email <input type="text" name="LvlChat" value="" />
<button type="submit" class="btn btn-default">Rechercher le membre</button>
</form>
  
<a href="http://localhost:8080/NekoAtsume/AdminMembres"><button class="btn btn-default">Afficher tous les membres</button></a>

  <tr>
    <th>Nom membre</th>
    <th>Email Membre</th>
   
	<th></th>
	<th></th>
  </tr>
  <c:forEach var="inscrit" items="${listInscrit}">
  <tr>
    <td>${inscrit.pseudo}</td>
     <td>${inscrit.email}</td>
    <td><a href="">Bannir</a></td>
<%--     http://localhost:8080/NekoAtsume/membre/${chat.idChat}/bannir --%>
  </tr>
  </c:forEach>
</table> 
<%@ include file="footer.jsp" %>