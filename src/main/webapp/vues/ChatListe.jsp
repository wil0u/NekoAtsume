<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
	<jsp:param name="pageTitle" value="Liste chat" />
   <jsp:param name="pageHeader" value="Liste des chats" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>                          
 <table  class="table table-striped">
<caption>Guys, my name is Ankush Gorav</caption>
  <tr>
    <th>Nom chat</th>
    <th>Image chat</th>
    <th>Power Lv.</th>
	<th></th>
	<th></th>
  </tr>
  <c:forEach var="chat" items="${listChat}">
  <tr>
    <td>${chat.nomChat}</td>
    <td><img src="${chat.cheminPhotoChat}" class="img-rounded" /></td>
    <td	>${chat.lvlChat}</td>
    <td><a href="http://localhost:8080/NekoAtsume/chat/${chat.idChat}">Détail du chat</a></td>
    <td><a href="http://localhost:8080/NekoAtsume/chat/${chat.idChat}/astuce">Ajouter une astuce</a></td>
  </tr>
  </c:forEach>
</table> 


<%@ include file="footer.jsp" %>
