<%@ include file="../partials/header.jsp" %>

<section id="top" class="padding-top-navbar">

  <div class="container">
    <p>View user:</p>
    <p><c:out value="${user.name}" /></p>
    <p><c:out value="${user.email}" /></p>
    <p><c:out value="${user.password}" /></p>

    <a type="button" class="btn btn-primary" href="/users/edit?id=<c:out value='${user.id}' />">Edit user</a>
  </div>
</section>

<%@ include file="../partials/footer.jsp" %>