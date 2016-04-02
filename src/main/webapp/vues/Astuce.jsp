<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Détail de l'astuce : ${Astuce.titre } " />
   <jsp:param name="pageTitle" value="Détail astuce" />
   <jsp:param name="emailUser" value="${emailUser }" />
   <jsp:param name="Admin" value="${Admin}" />
</jsp:include>
<a href="http://localhost:8080/NekoAtsume/astuces"><button class="btn btn-default">Revenir à l'affichage des astuces</button></a>
<br />
<br>
<c:choose>
    <c:when test="${cas eq '0'}">
         <div class="text-info">${Info}</div>
    </c:when>
    <c:otherwise>
		<div class="bouton_Showr"> <a class="btn btn-default"  href="http://localhost:8080/NekoAtsume/astuce/${Astuce.idAstuce}/liker/${cas}">like</a></div>
		<div class="bouton_Showr"> <a class="btn btn-default"  href="http://localhost:8080/NekoAtsume/astuce/${Astuce.idAstuce}/Disliker/${cas}">Dislike</a></div>
		<div class="text-info">${Info}</div>
    </c:otherwise>
</c:choose>
<div class="progress">
  <div class="progress-bar progress-bar-success" role="progressbar" style="width:70%">
    Nom de votes pour (% à renvoyer dans la barre)
  </div>
   <div class="progress-bar progress-bar-danger" role="progressbar" style="width:30%">
     Nom de votes contre (% à renvoyer dans la barre)
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
			<span class="label label-default">Chat</span>
				${Astuce.categorie.nomCategorie }
				//
				<c:if test="${not empty Astuce.chat}">
   				
					${Astuce.chat.nomChat}
					
			</c:if>		
			</li>
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