<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Les astuces du chat : ${Chat.nomChat}" />
   <jsp:param name="pageTitle" value="Liste astuces" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>

<a href="http://localhost:8080/NekoAtsume/astuces"><button class="btn btn-default">Revenir à l'affichage des astuces</button></a>
<br>
<table class="table table-hover">

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






<%@ include file="footer.jsp" %>