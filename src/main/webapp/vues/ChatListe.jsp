<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>${WelcomeMessage}</h2>
		<ul>
			<c:forEach var="chat" items="${listChat}">
				<li>${chat.nomChat}-----${chat.cheminPhotoChat}----${chat.couleurChat}----${chat.nomJaponnaisChat}</li>
			</c:forEach>
		</ul>
</body>
</html>
