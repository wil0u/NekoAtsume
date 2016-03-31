 <%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Panneau d'administration" />
   <jsp:param name="pageTitle" value="Panneau d'administration des Chats" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
 <table  class="table table-striped">
 <div class="ligne"></div>
<table  class="table table-striped">
 
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
     
<%--   <--!   <c:if ...> --> --%>
<!--  		<td><a href="">Bannir</a></td> -->
<%--  	</c:if> --%>
   
    
<%--     http://localhost:8080/NekoAtsume/membre/${chat.idChat}/bannir --%>
  </tr>
  </c:forEach>
</table> 
 <%@ include file="footer.jsp" %>