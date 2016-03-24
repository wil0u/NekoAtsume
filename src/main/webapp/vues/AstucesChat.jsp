<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Liste des astuces" />
   <jsp:param name="pageTitle" value="Liste astuces" />
</jsp:include>

Concerne le chat ${Chat.nomChat}


<table class="table table-hover">
<caption>Astuces :</caption>
  <tr>
    <th>Titre</th>
    <th>Lien</th>
  </tr>
  <c:forEach var="astuce" items="${listeAstuces}">
  <tr>
    <td>${astuce.titre}</td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}">Détail</a></td>
  </tr>
  </c:forEach>
</table> 






<%@ include file="headerTag.jsp" %>