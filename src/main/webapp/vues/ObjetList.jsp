<%@ include file="headerTag.jsp" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/vues/header.jsp" >	
	<jsp:param name="pageTitle" value="Liste objet" />
   <jsp:param name="pageHeader" value="Liste des Objets" />
   <jsp:param name="emailUser" value="${emailUser }" />
<jsp:param name="Admin" value="${Admin}" />
</jsp:include> 

<!-- Feuille CSS AJOUTEE  -->
<spring:url value="/resources/css/pageHeader.css" var="pageHeaderCSS" />
<link href="${pageHeaderCSS}" rel="stylesheet" />





 <table  class="table table-striped">
 <caption>Balles</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->
<!-- </tr> -->

		 
		<c:forEach var="objet" items="${balls}">
			  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
		</c:forEach>
</table> 		
	
	
	
	
	
		
 <table  class="table table-striped">
 <caption>Boîtes</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->

<!-- </tr> -->

 
		<c:forEach var="objet" items="${boxes}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
    
  </tr>
		</c:forEach>
</table> 








 <table  class="table table-striped">
 <caption>Meubles</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->

<!-- </tr> -->

		 
		<c:forEach var="objet" items="${furniture}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  
  </tr>
		</c:forEach>

</table> 






 <table  class="table table-striped">
 <caption>Tunnels</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->

<!-- </tr> -->


		 
		<c:forEach var="objet" items="${tunnels}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
   
  </tr>
		</c:forEach>
	







 <table  class="table table-striped">
 <caption>Jouets</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->

<!-- </tr> -->


	 
		<c:forEach var="objet" items="${toys}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
		</c:forEach>

</table> 






 <table  class="table table-striped">
 <caption>Chauffages</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->

<!-- </tr> -->

		 
		<c:forEach var="objet" items="${heating}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
		</c:forEach>
</table> 







 <table  class="table table-striped">
 <caption>Sacs / Cachettes</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->

<!-- </tr> -->


	 
			<c:forEach var="objet" items="${bagsHiding}">
							  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
			</c:forEach>

</table> 
  
  
  
  
 <table  class="table table-striped">
 <caption>Arbres à chats</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->

<!-- </tr> -->

		 
		<c:forEach var="objet" items="${scratching}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
   
  </tr>
		</c:forEach>

</table> 








	
 <table  class="table table-striped">
 <caption>Baskets</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->

<!-- </tr> -->


 
		<c:forEach var="objet" items="${baskets}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  
  </tr>
		</c:forEach>

</table> 









 <table  class="table table-striped">
 <caption>Nourritures</caption>
<!-- <tr> -->
<!--     <th>Nom objet</th> -->
<!--     <th>Image objet</th> -->
<!--     <th>Prix.</th> -->

<!-- </tr> -->
 
		<c:forEach var="objet" items="${foods}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
		</c:forEach>
		</table> 
		
		
<%@ include file="footer.jsp" %>
