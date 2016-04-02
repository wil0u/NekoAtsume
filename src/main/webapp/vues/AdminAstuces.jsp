 <%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Panneau d'administration des Astuces" />
   <jsp:param name="pageTitle" value="Panneau d'administration des Astuces" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
 <table  class="table table-striped">

<c:if test="${not empty Succes}">

<div class="alert alert-success">${Succes}</div>

</c:if>
<table class="table table-striped" >
  <tr>
    <th>Titre</th>
    <th>Chat concern�</th>
    <th>Lien</th>
    <th>Suppression</th>
  </tr>
  <c:forEach var="astuce" items="${listAstuce}">
  <tr>
    <td>${astuce.titre}</td>  
    <td><a href="http://localhost:8080/NekoAtsume/chat/${astuce.chat.idChat}">${astuce.chat.nomChat}</a></td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}/moderer">Modifier</a></td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}/supprimerAstuce">Supprimer</a></td>
  </tr>
  </c:forEach>
</table>
 <%@ include file="footer.jsp" %>