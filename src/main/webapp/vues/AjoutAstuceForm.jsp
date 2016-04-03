<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Ajout astuce : ${chat.nomChat }" />
   <jsp:param name="pageTitle" value="Formulaire d'ajout d'astuce" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>

<!--  ajout d'une astuce formulaire. Essai de rajout des catégoriiies.. -->

	<c:if test="${not empty error}">
		<div class="alert alert-danger">${error}</div>
	</c:if>
	
<form:errors path="astuce.*"/>
<form method="post" action="/NekoAtsume/chat/${chat.idChat}/astuce"  >

	<div class="form-group">
		<label  for="inputTitre">Titre</label>
		<input type="text" id="inputTitre" name="titre" path="titre" class="form-control">
	</div>
	

<!-- <label  for="inputAstuce">Type de l'astuce</label> -->
<!-- <span id="helpBlock" class="help-block"> -->
<%--  <c:forEach var="cat" items="${categorieAstuces}">  --%>
<%-- <li>${cat.nomCategorieAstuce} : ${cat.descriptionCategorieAstuce}</li></c:forEach> --%>
<!-- </span>	 -->

<!-- <div class="form-group"> -->
<!--     <SELECT class="form-control"> -->
<%--    <c:forEach var="categorie" items="${categorieAstuces}"> --%>
   
<%--    <OPTION name="categorie" path="categorie" class="form-control" id="inputCategorie" value = "${categorie}" > ${categorie.nomCategorieAstuce}</option>	 --%>
<%--    </c:forEach> --%>
<!--     </SELECT> -->
<!-- </div> -->

	
<!-- <div class="form-group"> -->
<%--  <c:forEach var="categorie" items="${categorieAstuces}"> --%>
<%--   <input type="radio" class="form-control" name="categorie"  path="categorie" value = "${categorie}"> ${categorie.nomCategorieAstuce} <br> --%>
<%--   </c:forEach> --%>
<!-- </div> -->
	
	
	<div class="form-group">
		<label  for="inputAstuce">Description de l'astuce</label>
		<textarea class="form-control" name="astuce" path="astuce" id="inputAstuce" aria-describedby="helpBlock" rows="3"></textarea>
		
	</div>
	
		    <c:if test="${not empty chat.nomChat}">
   				<li class="list-group-item">
   				<span class="label label-default">Chat concerné</span>
					${chat.nomChat}</li>
					
					<li class="list-group-item">
				<span class="label label-default">Image</span>
				<img src="${chat.cheminPhotoChat}" />
			</li>
					
			</c:if>		

<h3>
	Beds <a
		href="javascript:document.getElementById('re000').style.display='block';document.getElementById('re000').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re000').style.display='none';document.getElementById('re000').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re000" style="display: none;">
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
</div></div></div>



<h3>
	Balls <a
		href="javascript:document.getElementById('re001').style.display='block';document.getElementById('re001').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re001').style.display='none';document.getElementById('re001').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re001" style="display: none;">
	

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
</div>





     <h3>
	Boxes<a
		href="javascript:document.getElementById('re002').style.display='block';document.getElementById('re002').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re002').style.display='none';document.getElementById('re002').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re002" style="display: none;">


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
</div>



<h3>
	Furnitures<a
		href="javascript:document.getElementById('re003').style.display='block';document.getElementById('re003').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re003').style.display='none';document.getElementById('re003').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re003" style="display: none;">

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
</div>



<h3>
	Tunnels<a
		href="javascript:document.getElementById('re004').style.display='block';document.getElementById('re004').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re004').style.display='none';document.getElementById('re004').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re004" style="display: none;">


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
</div>


<h3>
	Toys<a
		href="javascript:document.getElementById('re005').style.display='block';document.getElementById('re005').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re005').style.display='none';document.getElementById('re005').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re005" style="display: none;">
	
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
		</div></div>
		
		

<h3>
	Heatings<a
		href="javascript:document.getElementById('re006').style.display='block';document.getElementById('re006').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re006').style.display='none';document.getElementById('re006').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re006" style="display: none;">
	


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
</div>


<h3>
	Bags/Hiding<a
		href="javascript:document.getElementById('re007').style.display='block';document.getElementById('re007').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re007').style.display='none';document.getElementById('re007').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re007" style="display: none;">

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
</div>



<h3>
	Scratching<a
		href="javascript:document.getElementById('re008').style.display='block';document.getElementById('re008').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re008').style.display='none';document.getElementById('re008').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re008" style="display: none;">

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
</div>


<h3>
	Baskets<a
		href="javascript:document.getElementById('re009').style.display='block';document.getElementById('re009').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re009').style.display='none';document.getElementById('re009').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re009" style="display: none;">


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
</div>

	

<h3>
	Foods<a
		href="javascript:document.getElementById('re010').style.display='block';document.getElementById('re010').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
		</button>
	</a> <a
		href="javascript:document.getElementById('re010').style.display='none';document.getElementById('re010').releaseCapture();">
		<button type="button" class="btn btn-default" aria-label="Left Align">
			<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
		</button>
	</a>
</h3>
<div id="re010" style="display: none;">

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
</div>

			</br>
			<br>
			<div style="text-align: center;">
			<button type="submit" class="btn btn-success"
			>Submit</button></div>
</form>	

<%@ include file="footer.jsp" %>