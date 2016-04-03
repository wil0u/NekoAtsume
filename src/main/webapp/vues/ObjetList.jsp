<%@ include file="headerTag.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/vues/header.jsp">
	<jsp:param name="pageTitle" value="Liste objet" />
	<jsp:param name="pageHeader" value="Liste des Objets" />
	<jsp:param name="emailUser" value="${emailUser }" />
	<jsp:param name="Admin" value="${Admin}" />
</jsp:include>
<!--  liste des objets -->
<!-- Feuille CSS AJOUTEE  -->

<link href="${pageHeaderCSS}" rel="stylesheet" />


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
	<table class="table table-striped">

		<c:forEach var="objet" items="${beds}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>
			</tr>
		</c:forEach>

	</table>
</div>


<h3>
	Balls <a
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
	<table class="table table-striped">

		<c:forEach var="objet" items="${balls}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>
			</tr>
		</c:forEach>

	</table>
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
	<table class="table table-striped">

		<c:forEach var="objet" items="${boxes}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img
					src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>

			</tr>
		</c:forEach>

	</table>
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
	<table class="table table-striped">

		<c:forEach var="objet" items="${furniture}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img
					src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>

			</tr>
		</c:forEach>

	</table>
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
	<table class="table table-striped">

		<c:forEach var="objet" items="${tunnels}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img
					src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>

			</tr>
		</c:forEach>


	</table>
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
	<table class="table table-striped">

		<c:forEach var="objet" items="${toys}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img
					src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>
			</tr>
		</c:forEach>



	</table>
</div>


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
	<table class="table table-striped">
		<c:forEach var="objet" items="${heating}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img
					src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>
			</tr>
		</c:forEach>



	</table>
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
	<table class="table table-striped">

		<c:forEach var="objet" items="${bagsHiding}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img
					src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>
			</tr>
		</c:forEach>



	</table>
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
	<table class="table table-striped">

		<c:forEach var="objet" items="${scratching}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img
					src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>

			</tr>
		</c:forEach>


	</table>
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
	<table class="table table-striped">

		<c:forEach var="objet" items="${baskets}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img
					src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>

			</tr>
		</c:forEach>


	</table>
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
	<table class="table table-striped">

		<c:forEach var="objet" items="${foods}">
			<tr>
				<td>${objet.nomObjet}</td>
				<td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
				<td>${objet.prix}<img
					src="${objet.monnaie.cheminPhotoMonnaie}"
					style="width: 30px; height: 30px" class="img-rounded" /></td>
			</tr>
		</c:forEach>


	</table>
</div>



<%@ include file="footer.jsp"%>
