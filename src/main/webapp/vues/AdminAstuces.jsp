  <%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Panneau d'administration des Astuces" />
   <jsp:param name="pageTitle" value="Panneau d'administration des Astuces" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
 <table  class="table table-striped">

<!-- affichage de la liste des astuce avec options de modération -->
<c:if test="${not empty Succes}">

<div class="alert alert-success">${Succes}</div>

</c:if>
<table class="table table-striped" >
  <tr>
    <th>Titre</th>
    <th>Chat concerné</th>
    <th>Date de création</th>
    <th>Modération</th>
    <th>Suppression</th>
    <th>Publication</th>
  </tr>
  <c:forEach var="astuce" items="${listAstuce}">
  <tr>  
    <td>${astuce.titre}</td>  
    <td><a href="http://localhost:8080/NekoAtsume/chat/${astuce.chat.idChat}">${astuce.chat.nomChat}</a></td>
    <td>${astuce.date }</td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}/moderer" class="btn btn-primary" role="button">Modifier</a></td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}/supprimerAstuce" class="btn btn-danger" role="button">Supprimer</a></td>
   <c:if test="${astuce.publie}"><td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}/cacher"class="btn btn-primary" role="button">Cacher l'astuce</a></td></c:if>
    <c:if test="${not astuce.publie}"><td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}/publier" class="btn btn-info" role="button">Publier l'astuce</a></td></c:if>
  </tr>
  </c:forEach>
</table>
 <%@ include file="footer.jsp" %>