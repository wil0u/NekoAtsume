<%@ include file="headerTag.jsp" %>

<jsp:include page="/vues/header.jsp" >	
   <jsp:param name="pageHeader" value="Changement de mot de passe" />
   <jsp:param name="pageTitle" value="Changer mdp" />
   <jsp:param name="emailUser" value="${emailUser }" />
</jsp:include>
<h1 class="text-danger">${error}</h1>
<form method="POST" action="/NekoAtsume/submitMotPass" >
  <div class="form-group">
    <label for="exampleInputEmail1">Password</label>
    <input type="password" name="pass1" class="form-control" id="exampleInputEmail1" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Tapez à nouveau votre Password</label>
    <input type="password" name="pass2" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
  </form>


<%@ include file="footer.jsp" %>