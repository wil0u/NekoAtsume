<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Formulaire d'inscription" />
   <jsp:param name="pageTitle" value="Inscription" />
   <jsp:param name="emailUser" value="${emailUser }" />
  <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
<div class="text-danger">${error1}
${error2}
${error3}
${error4}
${error5} </div>
<br>
<form:errors path="compte.*"/>

	<form method="post" action="/NekoAtsume/compte">
		<fieldset>
			<div class="form-group">
				<label for="exampleInputEmail1">
				<span class="label label-default" class="requis">Email</span></label>
				
					<input type="email" name="email"
					class="form-control" id="exampleInputEmail1" placeholder="Email"
					value="" size="20" maxlength="60" />
					<span class="erreur">${erreurs['email']}</span>
			</div>
			<div class="form-group">
				<label for="Pseudo">
				<span class="label label-default"	class="requis">Pseudo</span></label>
					
					<input type="text" name="pseudo"
					class="form-control" id="Pseudo" placeholder="Pseudo" value=""
					size="20" maxlength="20" /> 
					<span class="erreur">${erreurs['motdepasse']}</span>
				 			</div>
					
						<div class="form-group">
				<label for="exampleInputPassword1">
				<span class="label label-default"	class="requis">Mot de Passe</span></label>
					
					<input type="password" name="mdp"
					class="form-control" id="exampleInputPassword1"
					placeholder="Mot de passe" value="" size="20" maxlength="20" /> 
					<span class="erreur">${erreurs['confirmation']}</span>
			</div>
			
		     <div class="form-group">
				<label for="confirmation">
				<span class="label label-default"	class="requis">Confirmation du mot de Passe</span></label>
					
					<input type="password" name="confirmation" value=""  
					id="confirmation" class="form-control" placeholder="Confirmation du mot de passe"/> 
					<span class="erreur">${erreurs['nom']}</span>
			</div>

			<input type="submit" value="Inscription" class="btn btn-default" /> <br />
		</fieldset>
	</form>

</form>



<%@ include file="footer.jsp" %>