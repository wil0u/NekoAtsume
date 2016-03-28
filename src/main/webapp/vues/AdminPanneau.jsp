<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Panneau d'administration" />
   <jsp:param name="pageTitle" value="Panneau d'administration" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
<a href="http://localhost:8080/NekoAtsume/AdminChats"><button class="btn btn-default">Modérer les chats</button></a>
<a href="http://localhost:8080/NekoAtsume/AdminAstuces"><button class="btn btn-default">Modérer les astuces</button></a>
<a href="http://localhost:8080/NekoAtsume/AdminMembres"><button class="btn btn-default">Modérer les membres</button></a>

<%@ include file="footer.jsp" %>