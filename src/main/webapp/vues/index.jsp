<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
	<jsp:param name="pageTitle" value="Bienvenue !" />
   <jsp:param name="pageHeader" value="Accueil" />
    <jsp:param name="emailUser" value="${emailUser }" />
       <jsp:param name="Admin" value="${Admin}" />
</jsp:include>

<!--  donne la page d'accueil -->
<c:if test="${not empty succes}">
<div class="alert alert-success">${succes}</div>
 </c:if>

<div class="container-fluid" id= "container-fluid">
<div class="jumbotron">

  <h1>Astuces Neko Atsume !</h1>
  <p>Inscrivez-vous pour entrer les astuces du jeu !
  
  <a href="https://itunes.apple.com/fr/app/neko-atsume-kitty-collector/id923917775?mt=8">
   <img id = "imageIndex" class="img-rounded img-responsive" width="150" height="115" src="http://localhost:8080/NekoAtsume/resources/imagesFond/android apple.png" alt="ImageEnt�te"></a>
     <a href="https://play.google.com/store/apps/details?id=jp.co.hit_point.nekoatsume&hl=fr">
  <img id = "imageIndex" class="img-rounded img-responsive" width="150" height="115" src="http://localhost:8080/NekoAtsume/resources/imagesFond/android neko.png" alt="ImageEnt�te"></a></p>
  <div>Neko Atsume astuces est un site vous permettant de retrouver les astuces pour votre collectionneur de chats pr�f�r� !
Celles-ci sont not�es par les membres du site !
</div>
 </div>  
   <br>
   </div>
  <h2> Un coup d'oeil sur toutes les astuces post�es la semaine derni�re !</h1></br>
   <table class="table table-striped">

  <tr>
    <th>Titre</th>
    <th>Chat concern�</th>
    <th>Date de cr�ation</th>
    <th>Lien</th>
     </tr>
  <c:forEach var="astuce" items="${ListeAstuce}">
  <tr>
    <td>${astuce.titre}</td>
    <td><a href="http://localhost:8080/NekoAtsume/chat/${astuce.chat.idChat}">${astuce.chat.nomChat}</a></td>
    <td>${astuce.date}</td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}" class="btn btn-primary" role="button">Lien</a></td>
  </tr>
  </c:forEach>
</table>

  

<%@ include file="footer.jsp" %>		

