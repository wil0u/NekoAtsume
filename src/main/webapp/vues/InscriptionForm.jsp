<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Formulaire d'inscription" />
   <jsp:param name="pageTitle" value="Inscription" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
<h1 class="text-danger">${error}</h1>
<form:errors path="compte.*"/>
<form method="post" action="/NekoAtsume/compte"  >
  <div class="form-group">
    <label for="exampleInputEmail1">Adresse email</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="Pseudo">Pseudo</label>
    <input type="text" name="pseudo" class="form-control" id="Pseudo" placeholder="Pseudo">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="mdp" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  


  <button type="submit" class="btn btn-default">Submit</button>
</form>



<%@ include file="footer.jsp" %>