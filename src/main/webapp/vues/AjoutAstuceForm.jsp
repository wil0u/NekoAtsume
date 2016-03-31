<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Ajout astuce pour le chat ${chat.nomChat }" />
   <jsp:param name="pageTitle" value="Formulaire d'ajout d'astuce" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
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
		<span id="helpBlock" class="help-block">Veuillez écrire le détail de votre astuce</span>	
		<textarea class="form-control" name="astuce" path="astuce" id="inputAstuce" class="form-control" aria-describedby="helpBlock" rows="3"></textarea>
		
	</div>
	
		    
     
<div class="container">
	<div class="form-group">
		<legend>Beds</legend>
		<c:forEach var="objet" items="${beds}">
			
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
					</p>
				</div>
				
		</c:forEach>
</div>
</div>
<div class="container">
			<div class="form-group">
				<legend>Balls</legend>
				<c:forEach var="objet" items="${balls}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>

		</div>

<div class="container">
			<div class="form-group">
				<legend>Boxes</legend>
				<c:forEach var="objet" items="${boxes}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>

		</div>
<div class="container">
			<div class="form-group">
				<legend>Furniture</legend>
				<c:forEach var="objet" items="${furniture}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Tunnels</legend>
				<c:forEach var="objet" items="${tunnels}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Toys</legend>
				<c:forEach var="objet" items="${toys}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Heating</legend>
				<c:forEach var="objet" items="${heating}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Bags/Hiding</legend>
				<c:forEach var="objet" items="${bagsHiding}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Scratching</legend>
				<c:forEach var="objet" items="${scratching}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Baskets</legend>
				<c:forEach var="objet" items="${baskets}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Foods</legend>
				<c:forEach var="objet" items="${foods}">
				<div class="col-md-3" >
					<p> 
					<label class="checkbox-inline"> <input type="checkbox"
						name="listObjetId" value="${objet.idObjet}"><img
						src="${objet.cheminPhotoObjet}" class="img-thumbnail"
						style="width: 50px; height: 50px" />${ objet.nomObjet}
					</label>
					</p>
				</div>
				</c:forEach>
			</div>
			</div>
			</br>
			<br>
			<div style="text-align: center;">
			<button type="submit" class="btn btn-default"
				id="JESUISUNVILAINBOUTON">Submit</button></div>
</form>	

<%@ include file="footer.jsp" %>