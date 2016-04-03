<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Détail de l'astuce : ${Astuce.titre } " />
   <jsp:param name="pageTitle" value="Détail astuce" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>

<!--  permet d'afficher l'astuce avec les likes les dislikes   -->
<a href="http://localhost:8080/NekoAtsume/astuces"><button class="btn btn-primary">Revenir à l'affichage des astuces</button></a>
<br />
<br>
<c:choose>
    <c:when test="${cas eq '0'}">
         <div class="text-info">${Info}</div>
    </c:when>
    <c:otherwise>
    <center>
		 <a href="http://localhost:8080/NekoAtsume/astuce/${Astuce.idAstuce}/liker/${cas}"> <button type="button" class="btn btn-success">
  <span class="btn glyphicon glyphicon-thumbs-up"  aria-hidden="true"></span>
</button> </a> <a href="http://localhost:8080/NekoAtsume/astuce/${Astuce.idAstuce}/disliker/${cas}"><button type="button" class="btn btn-danger">
  <span class="btn glyphicon glyphicon-thumbs-down"  aria-hidden="true"></span> 
</button></a>
		 
		<div class="text-info">${Info}</div></center>
    </c:otherwise>
    
</c:choose>
Nombres de votes total : ${votesTotal}
  <div class="progress">
  <div class="progress-bar progress-bar-success" role="progressbar" style="width:${pourCentLike}%">
    ${pourCentLike}% / ${votesPour} votes
  </div>
   <div class="progress-bar progress-bar-danger" role="progressbar" style="width:${pourCentDislike}%">
     ${pourCentDislike}% / ${votesContre} votes
  </div>
</div>

		<ul>
			<li class="list-group-item" >
			<span class="label label-default">Identifiant</span>
				${Astuce.idAstuce }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Titre</span>
				${Astuce.titre }
			</li>
			<li class="list-group-item">
			<span class="label label-default">Date de création</span>
				${Astuce.date }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Catégorie de l'Astuce</span>
				${Astuce.categorie.nomCategorieAstuce}
				</li>
				
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
			
				<li class="list-group-item">
			<span class="label label-default">Astuce</span>
				${Astuce.astuce }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Auteur</span>
				${Astuce.auteur.pseudo }
			</li>
		
			<li class="list-group-item">
			<span class="label label-default">Objets associés</span>
						<ul>
					<c:forEach var="objet" items="${Astuce.listObjet}">
						<li>${objet.nomObjet}
					</c:forEach>
				</ul>
			</li>
			
			
		</ul>
		
		
<%@ include file="footer.jsp" %>