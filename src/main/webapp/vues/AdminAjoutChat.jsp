<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Ajouter un chat" />
   <jsp:param name="pageTitle" value="Ajouter un Chat" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
 <a href="http://localhost:8080/NekoAtsume/AdminChats" class="btn btn-default" role="button">Revenir au Panneau d'administration des Chats</a>
<div class="text-danger">${error1}
${error2}
${error3}
${error4}
${error5} </div>

<form:errors path="compte.*"/> 
<!-- A MODIFIER !!!! -->

	<form method="post" action="/NekoAtsume/AdminAjoutChat" action="<c:url value="/upload" />">
		<fieldset>
			<div class="form-group">
			<span class="label label-default">Nom du chat</span>
				<label for="NomChat"><span
					class="requis"></span></label> <input type="text" 
					class="form-control" id="NomChat" 
					value="" size="20" maxlength="60" />
					<span class="erreur">${erreurs['email']}</span>
			</div>
			<div class="form-group">
			<span class="label label-default">Couleur du chat</span>
				<label for="CouleurChat"><span
					class="requis"></span></label> <input type="text" 
					class="form-control" id="CouleurChat" 
					value="" size="20" maxlength="60" />
					<span class="erreur">${erreurs['email']}</span>
			</div>
			
				<div class="form-group">
			<span class="label label-default">Caractère du Chat</span>
				<label for="CaractereChat"><span
					class="requis"></span></label> <input type="text" 
					class="form-control" id="CaractereChat" 
					value="" size="20" maxlength="60" />
					<span class="erreur">${erreurs['email']}</span>
			</div>
			
			<div class="form-group">
			<span class="label label-default">Momento du Chat</span>
				<label for="MomentoChat"><span
					class="requis"></span></label> <input type="text" 
					class="form-control" id="MomentoChat" 
					value="" size="20" maxlength="60" />
					<span class="erreur">${erreurs['email']}</span>
			</div>
			
			<div class="form-group">
			<span class="label label-default">Nom Japonais du Chat</span>
				<label for="NomJaponaisChat"><span
					class="requis"></span></label> <input type="text" 
					class="form-control" id="NomJaponaisChat" 
					value="" size="20" maxlength="60" />
					<span class="erreur">${erreurs['email']}</span>
			</div>
			<label for="fichier">Emplacement du fichier <span class="requis">*</span></label>

                <input type="file" id="fichier" name="fichier" />

                <br />

			<input type="submit" value="Ajouter le chat" class="btn btn-success btn-lg" /> <br />
		</fieldset>
	</form>
	

</form>



<%@ include file="footer.jsp" %>