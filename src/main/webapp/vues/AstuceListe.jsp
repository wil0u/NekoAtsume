<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="container">
    <div class="page-header">
      <h1>Liste de toutes les astuces</h1>
    </div>
<table class="table table-hover">
  <tr>
    <th>Titre</th>
    <th>Chat concerné</th>
    <th>Lien</th>
  </tr>
  <c:forEach var="astuce" items="${ListeAstuce}">
  <tr>
    <td>${astuce.titre}</td>  
    <td><a href="http://localhost:8080/NekoAtsume/chat/${astuce.chat.idChat}">${astuce.chat.nomChat}</a></td>
    <td><a href="http://localhost:8080/NekoAtsume/astuce/${astuce.idAstuce}">Détail</a></td>
  </tr>
  </c:forEach>
</table>
  </div> 
</body>
</html>
