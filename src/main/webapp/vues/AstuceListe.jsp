<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Liste de toutes les astuces" />
   <jsp:param name="pageTitle" value="Liste astuces" />
   <jsp:param name="emailUser" value="${emailUser}" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>

 <div class="text-danger">${succes} </div>
 <div class="text-danger">${error} </div>


 <form method="post" action="/NekoAtsume/chat/RechAstucesChat">          
Tapper le nom d'un chat pour rechercher ses astuces<input type="text" name="RechAstucesChat" value=""  />
<button type="submit" class="btn btn-default" id ="bouton2" >Rechercher des astuces</button>
</form>
<table class="table table-hover">
  <tr>
    <th>Titre</th>
    <th>Chat concerné</th>
     </tr>
  <c:forEach var="astuce" items="${ListeAstuce}">
  <tr>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}">${astuce.titre}</a></td>
    <td><a href="http://localhost:8080/NekoAtsume/chat/${astuce.chat.idChat}">${astuce.chat.nomChat}</a></td>
    
  </tr>
  </c:forEach>
</table>


<%@ include file="footer.jsp" %>