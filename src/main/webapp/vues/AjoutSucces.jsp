<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Bien joué ;)" />
   <jsp:param name="pageTitle" value="BRAVO !" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>

<!--  j'ignore pourquoi cette page est toujours vivante -->

<p class="bg-success">Ajout de l'astuce avec succès !</p>







<%@ include file="footer.jsp" %>