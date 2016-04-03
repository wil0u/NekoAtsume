<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Modification d'astuce : ${Astuce.chat.nomChat }" />
   <jsp:param name="pageTitle" value="Formulaire d'ajout d'astuce" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
	</div>
			
			<c:if test="${not empty Astuce.chat}">
   				<li class="list-group-item">
   				<span class="label label-default">Chat concerné</span>
					${Astuce.chat.nomChat}</li>
					
					<li class="list-group-item">
			<div class="zoom">
			<span class="label label-default">Image</span>
				<img src="${Astuce.chat.cheminPhotoChat}" /></div>
			</li>
					
			</c:if>		

<!-- affichage du detail de l'astuce avec options de moderation -->
<h1 class="text-danger">${error}</h1>
<form:errors path="astuce.*"/>
<form method="post" action="/NekoAtsume/modifierAstuce"  >
<input type="hidden"  name="idAstuce" path="idAstuce" value="${Astuce.idAstuce }" class="form-control">
	<div class="form-group">
		<label  for="inputTitre">Titre</label>
		<input type="text" id="inputTitre" name="titre" path="titre" value="${Astuce.titre }" class="form-control">
	</div>
	
	<div class="form-group">
		<label  for="inputAstuce">Description de l'astuce</label>
		<span id="helpBlock" class="help-block">Veuillez écrire le détail de votre astuce</span>	
		<textarea class="form-control" name="astuce" path="astuce" id="inputAstuce" class="form-control" aria-describedby="helpBlock" rows="3">${Astuce.astuce }</textarea>
		
	</div>
		
		    

			
				
		
		
<div class="container">
	<div class="form-group">
		<legend>Beds</legend>
		<c:forEach var="objet" items="${beds}">
			<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
		</c:forEach>
</div>
</div>
<div class="container">
			<div class="form-group">
				<legend>Balls</legend>
				<c:forEach var="objet" items="${balls}">
		<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>

		</div>

<div class="container">
			<div class="form-group">
				<legend>Boxes</legend>
				<c:forEach var="objet" items="${boxes}">
		<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>

		</div>
<div class="container">
			<div class="form-group">
				<legend>Furniture</legend>
				<c:forEach var="objet" items="${furniture}">
		<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Tunnels</legend>
				<c:forEach var="objet" items="${tunnels}">
		<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Toys</legend>
				<c:forEach var="objet" items="${toys}">
		<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Heating</legend>
				<c:forEach var="objet" items="${heating}">
			<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Bags/Hiding</legend>
				<c:forEach var="objet" items="${bagsHiding}">
	<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Scratching</legend>
				<c:forEach var="objet" items="${scratching}">
		<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Baskets</legend>
				<c:forEach var="objet" items="${baskets}">
		<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
<div class="container">
			<div class="form-group">
				<legend>Foods</legend>
				<c:forEach var="objet" items="${foods}">
		<c:if test="${objet.isChecked eq 'T'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  checked><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				
				<c:if test="${objet.isChecked eq 'F'}">
				<div class="col-md-3" >
					<p> 
				
					
					<label class="checkbox-inline"> <input type="checkbox" name="listObjetId" value="${objet.idObjet}"  ><img src="${objet.cheminPhotoObjet}" class="img-thumbnail"
							style="width: 50px; height: 50px" />${ objet.nomObjet}
						</label>
						   
					</p>
				</div>
				</c:if>
				</c:forEach>
			</div>
			</div>
			</br>
			<br>
			<div style="text-align: center;">
			<button type="submit" class="btn btn-default"
				id="JESUISUNVILAINBOUTON">Modifier</button></div>
</form>	

<%@ include file="footer.jsp" %>