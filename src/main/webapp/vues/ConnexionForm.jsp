<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Formulaire de connexion" />
   <jsp:param name="pageTitle" value="Connexion" />
   <jsp:param name="emailUser" value="${emailUser }" />
  <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
<div class="text-danger">${error}</div>
<div class="text-info">${Info}</div>
<br>

<!--  affichage du formulaire de connection -->
<form method="post" action="/NekoAtsume/connexion">
	<fieldset>
		<div class="form-group">
			<span for="inputEmail3" class="label label-default" class="requis">Email</span>
			<input type="email" name="email" class="form-control"
				id="inputEmail3" placeholder="Email">
		</div>

		<div class="form-group">
			<span for="inputPassword3" class="label label-default" class="requis">Mot
				de passe</span> <input type="password" name="mdp" class="form-control"
				id="inputPassword3" placeholder="Password">
		</div>
		<button type="submit" class="btn btn-default">Se connecter</button>


	</fieldset>
</form>

<%@ include file="footer.jsp" %>