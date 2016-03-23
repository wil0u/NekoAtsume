<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Toutes les astuces : </h2>
		<ul>
			<c:forEach var="astuce" items="${ListeAstuce}">
				<li>${astuce.titre}-----${astuce.chat.nomChat}----<a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}">Détail</a> </li>
			</c:forEach>
		</ul>
</body>
</html>
