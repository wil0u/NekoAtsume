<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Detail du chat : ${Chat.nomChat } " />
   <jsp:param name="pageTitle" value="Détail chat" />
</jsp:include>



		<ul >
			<li>
				${Chat.idChat }
			</li>
		
			<li>
				${Chat.nomChat }
			</li>
		
			<li>
				<img src="${Chat.cheminPhotoChat}" />
			</li>
				<li>
				${Chat.couleurChat }
			</li>
		
			<li>
				${Chat.caractereChat }
			</li>
		
			<li>
				${Chat.memorialChat }
			</li>
			
			<li>
				${Chat.nomJaponnaisChat }
			</li>			
		</ul>

<c:choose>
    <c:when test="${empty ListeAstuces}">
         <h2>${Chat.nomChat } n'a pas d'astuce. </h2>
    </c:when>
    <c:otherwise>
       <h2>Liste des astuces associées a ${Chat.nomChat } : </h2>
<table class="table table-hover">
  <tr>
    <th>Titre</th>
    <th>Lien</th>
  </tr>
  <c:forEach var="astuce" items="${ListeAstuces}">
  <tr>
    <td>${astuce.titre}</td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}">Détail</a></td>
  </tr>
  </c:forEach>
</table> 
    </c:otherwise>
</c:choose>


<%@ include file="footer.jsp" %>


