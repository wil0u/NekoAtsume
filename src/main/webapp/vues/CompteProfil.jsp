<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Mon profil" />
   <jsp:param name="pageTitle" value="Mon profil" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
<c:if test="${not empty Succes}">
<div class="alert alert-success">${Succes}</div>
 </c:if>

		<ul class="list-group" >
		
			<li class="list-group-item" >
			<span class="label label-default">Email</span>
				${compte.email }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Pseudo</span>
				${compte.pseudo }
			</li>
			
		</ul>
<a href="http://localhost:8080/NekoAtsume/changerMotPass" class="btn btn-default" role="button">Changer de mot de passe</a>
<%@ include file="footer.jsp" %>
