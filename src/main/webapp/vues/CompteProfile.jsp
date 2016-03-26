<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Votre profile" />
   <jsp:param name="pageTitle" value="Votre profile" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>

		<ul class="list-group" >
		
			<li class="list-group-item" >
			<span class="label label-default">Votre email</span>
				${compte.email }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Votre pseudo</span>
				${compte.pseudo }
			</li>
			
		</ul>
<a href="http://localhost:8080/NekoAtsume/changerMotPass" class="btn btn-default" role="button">Changer de mot de passe</a>
<%@ include file="footer.jsp" %>
