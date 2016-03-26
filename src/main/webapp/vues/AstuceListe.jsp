<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Liste de toutes les astues" />
   <jsp:param name="pageTitle" value="Liste astuces" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>


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
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}">D�tail</a></td>
  </tr>
  </c:forEach>
</table>


<%@ include file="footer.jsp" %>