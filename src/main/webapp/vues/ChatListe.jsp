<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;    
}
</style>
</head>
<body>		
   <h2>Liste des chats : </h2>
 <table style="width:100%">
  <tr>
    <th>Nom chat</th>
    <th>Image chat</th>
    <th>Power Lv.</th>
	<th>Lien</th>
  </tr>
  <c:forEach var="chat" items="${listChat}">
  <tr>
    <td>${chat.nomChat}</td>
    <td><img src="${chat.cheminPhotoChat}" /></td>
    <td	>${chat.lvlChat}</td>
    <td><a href="http://localhost:8080/NekoAtsume/chat/${chat.idChat}">Détail</a></td>
  </tr>
  </c:forEach>
</table> 
</body>
</html>
