<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Detail de l'astuce : ${Astuce.titre } " />
   <jsp:param name="pageTitle" value="Detail astuce" />
</jsp:include>


		<ul>
			<li>
				${Astuce.idAstuce }
			</li>
		
			<li>
				${Astuce.titre }
			</li>
		
			<li>
				${Astuce.categorie.nomCategorie }
			</li>
				<li>
				${Astuce.astuce }
			</li>
		
			<li>
				${Astuce.auteur.pseudo }
			</li>
		
			<li> Objets associés :
				<ul>
					<c:forEach var="objet" items="${Astuce.listObjet}">
						<li>${objet.nomObjet}
					</c:forEach>
				</ul>
			</li>
			<c:if test="${not empty Astuce.chat}">
   				<li>
					${Astuce.chat.nomChat }
				</li>	
			</c:if>		
		</ul>
		
		
<%@ include file="footer.jsp" %>