<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
	<jsp:param name="pageTitle" value="Bienvenue !" />
   <jsp:param name="pageHeader" value="Accueil" />
    <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>


<div class="jumbotron">
  <h1>Hello, visiteur!</h1>
  <p>Bienvenue sur un fan site de Neko Atsume !</p>
  
</ul>

</div>
<%@ include file="footer.jsp" %>		