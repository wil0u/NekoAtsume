<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Ajout astuce pour le chat ${chat.nomChat }" />
   <jsp:param name="pageTitle" value="Formulaire d'ajout d'astuce" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>



<h1 class="text-danger">${error}</h1>
<form:errors path="astuce.*"/>
<form method="post" action="/NekoAtsume/chat/${chat.idChat}/astuce"  >
	<div class="form-group">
		<label  for="inputTitre">Titre</label>
		<input type="text" id="inputTitre" name="titre" path="titre" class="form-control">
	</div>
	<div class="form-group">
		<label  for="inputAstuce">Description de l'astuce</label>
		<textarea class="form-control" name="astuce" path="astuce" id="inputAstuce" class="form-control" aria-describedby="helpBlock" rows="3"></textarea>
		<span id="helpBlock" class="help-block">Veuillez écrire le détail de votre astuce dans le block de texte ci-dessus.</span>	
	</div>
	
	
	
	<c:forEach var="i" begin="1" end="5">
	<p> TRUC <c:out value="${i}"/>
	<c:forEach var="j" begin="1" end="5">
     NAME <c:out value="${j}"/></c:forEach>
</c:forEach>


	<div class="form-group">
		<legend>Beds</legend>
		<c:set var="i" value="${0}" />
		<c:forEach var="objet" items="${beds}">
		
			<c:if test="${i%5 == 0}">
				<c:set var="i" value="${i+1}" />
				<p>
			</c:if>
			        
		            <table class="table">
		            
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					<c:set var="i" value="${i+1}" />
					</table>
					
		</c:forEach>
		
	</div>
	</div>


	<div class="form-group">
		<legend>Balls</legend>
		<c:forEach var="objet" items="${balls}">
			<label class="checkbox-inline">
 				<input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
			</label>
		</c:forEach>
	</div>

	<div class="form-group">
		<legend>Boxes</legend>
		<c:forEach var="objet" items="${boxes}">
			<label class="checkbox-inline">
 				<input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
			</label>
		</c:forEach>
	</div>

	<div class="form-group">
		<legend>Furniture</legend>
		<c:forEach var="objet" items="${furniture}">
			<label class="checkbox-inline">
 				<input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
			</label>
		</c:forEach>
	</div>


	<div class="form-group">
		<legend>Tunnels</legend>
		<c:forEach var="objet" items="${tunnels}">
			<label class="checkbox-inline">
 				<input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
			</label>
		</c:forEach>
	</div>		

	<div class="form-group">
		<legend>Toys</legend>
		<c:forEach var="objet" items="${toys}">
			<label class="checkbox-inline">
 				<input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
			</label>
		</c:forEach>
	</div>

	<div class="form-group">
		<legend>Heating</legend>
		<c:forEach var="objet" items="${heating}">
			<label class="checkbox-inline">
 				<input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
			</label>
		</c:forEach>
	</div>

	<div class="form-group">
		<legend>Bags/Hiding</legend>
			<c:forEach var="objet" items="${bagsHiding}">
				<label class="checkbox-inline">
					<input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
				</label>
			</c:forEach>
	</div>

	<div class="form-group">
		<legend>Scratching</legend>
		<c:forEach var="objet" items="${scratching}">
			<label class="checkbox-inline">
				 <input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
			</label>
		</c:forEach>
	</div>

	<div class="form-group">
		<legend>Baskets</legend>
		<c:forEach var="objet" items="${baskets}">
			<label class="checkbox-inline">
 				<input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
			</label>
		</c:forEach>
	</div>


	<div class="form-group">
		<legend>Foods</legend>
		<c:forEach var="objet" items="${foods}">
			<label class="checkbox-inline">
				<input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail" style="width:50px;height:50px"/>${ objet.nomObjet}
			</label>
		</c:forEach>
	</div>
<button type="submit" class="btn btn-default" id="JESUISUNVILAINBOUTON">Submit</button>
</form>	

<%@ include file="footer.jsp" %>