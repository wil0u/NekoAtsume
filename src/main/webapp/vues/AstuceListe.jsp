<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Liste de toutes les astuces" />
   <jsp:param name="pageTitle" value="Liste astuces" />
   <jsp:param name="emailUser" value="${emailUser}" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>

 <div class="text-danger">${succes} </div>
<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>

<!--  affiche toutes les astuces -->

 <form method="post" action="/NekoAtsume/chat/RechAstucesChat">          
Tapper le nom d'un chat pour rechercher ses astuces<input type="text" name="RechAstucesChat" value=""  />
<button type="submit" class="btn btn-primary" id ="bouton2" >Rechercher des astuces</button>
</form>
 <table class="table table-striped">
  <tr>
    <th>Titre</th>
    <th>Chat concerné</th>
    <th>Catégorie</th>
    <th>Date de création</th>
    <th>Lien</th>
     </tr>
  <c:forEach var="astuce" items="${ListeAstuce}">
  <tr>
    <td>${astuce.titre}</td>
    <td><a href="http://localhost:8080/NekoAtsume/chat/${astuce.chat.idChat}">${astuce.chat.nomChat}</a></td>
    <td>${astuce.categorie.nomCategorieAstuce}</td>
    <td>${astuce.date}</td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}" class="btn btn-primary" role="button">Lien</a></td>
  </tr>
  </c:forEach>
</table>


<%@ include file="footer.jsp" %>