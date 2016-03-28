<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Panneau d'Administration des Astuces" />
   <jsp:param name="pageTitle" value="Panneau d'Administration des Astuces" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>

 <a href="http://localhost:8080/NekoAtsume/AdminPanneau" class="btn btn-default" role="button">Revenir au Panneau d'administration</a>

<c:if test="${not empty Succes}">

<div class="alert alert-success">${Succes}</div>

</c:if>
<table class="table table-hover">
  <tr>
    <th>Titre</th>
    <th>Chat concern�</th>
    <th>Lien</th>
  </tr>
  <c:forEach var="astuce" items="${ListeAstuce}">
  <tr>
    <td>${astuce.titre}</td>  
    <td><a href="http://localhost:8080/NekoAtsume/chat/${astuce.chat.idChat}">${astuce.chat.nomChat}</a></td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}/moderer">Mod�rer</a></td>
  </tr>
  </c:forEach>
</table>


<%@ include file="footer.jsp" %>