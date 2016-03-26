<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
	<jsp:param name="pageTitle" value="Liste objet" />
   <jsp:param name="pageHeader" value="Liste des Objets" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include> 







 <table  class="table table-striped">
 <caption><h2>Balls</h2></caption>
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>
</tr>

		 
		<c:forEach var="objet" items="${balls}">
			  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
		</c:forEach>
</table> 		
	
	
	
	
	
		
 <table  class="table table-striped">
 <caption>Boxes</caption>
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>

</tr>

 
		<c:forEach var="objet" items="${boxes}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
    
  </tr>
		</c:forEach>
</table> 








 <table  class="table table-striped">
 <caption>Furniture</caption>
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>

</tr>

		 
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
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>

</tr>


		 
		<c:forEach var="objet" items="${tunnels}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
   
  </tr>
		</c:forEach>
	







 <table  class="table table-striped">
 <caption>Toys</caption>
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>

</tr>


	 
		<c:forEach var="objet" items="${toys}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
		</c:forEach>

</table> 






 <table  class="table table-striped">
 <caption>Heating</caption>
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>

</tr>

		 
		<c:forEach var="objet" items="${heating}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
		</c:forEach>
</table> 







 <table  class="table table-striped">
 <caption>Bags/Hiding</caption>
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>

</tr>


	 
			<c:forEach var="objet" items="${bagsHiding}">
							  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
			</c:forEach>

</table> 
  
  
  
  
 <table  class="table table-striped">
 <caption>Scratchingv</caption>
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>

</tr>

		 
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
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>

</tr>


 
		<c:forEach var="objet" items="${baskets}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  
  </tr>
		</c:forEach>

</table> 









 <table  class="table table-striped">
 <caption>Foods</caption>
<tr>
    <th>Nom objet</th>
    <th>Image objet</th>
    <th>Prix.</th>

</tr>
 
		<c:forEach var="objet" items="${foods}">
						  <tr>
    <td>${objet.nomObjet}</td>
    <td><img src="${objet.cheminPhotoObjet}" class="img-rounded" /></td>
    <td	>${objet.prix} <img src="${objet.monnaie.cheminPhotoMonnaie}" style="width:30px;height:30px" class="img-rounded" /></td>
  </tr>
		</c:forEach>
		</table> 
		
		
<%@ include file="footer.jsp" %>
