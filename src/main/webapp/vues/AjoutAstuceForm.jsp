<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Formulaire d'ajout d'astuce" />
   <jsp:param name="pageTitle" value="Ajout astuce pour le chat ${chat.nomChat }" />
</jsp:include>


<form>
<div class="form-group">
<label  for="inputTitre">Titre</label>
<input type="text" id="inputTitre" class="form-control">
</div>
<div class="form-group">
<label  for="inputAstuce">Description de l'astuce</label>
<textarea class="form-control" id="inputAstuce" class="form-control" aria-describedby="helpBlock" rows="3"></textarea>
<span id="helpBlock" class="help-block">Veuillez écrire le détail de votre astuce dans le block de texte ci-dessus.</span>	
</div>
<div class="form-group">
<c:forEach var="objet" items="${listeObjets}">

 <label class="checkbox-inline">
 <input type="checkbox" id="inlineCheckbox1" value="option1"><img src="${objet.cheminPhotoObjet}"/>${ objet.nomObjet}
</label>
</c:forEach>
</div>
</form>	

<%@ include file="footer.jsp" %>