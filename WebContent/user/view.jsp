<%@ include file="../partials/header.jsp" %>

<section id="top" class="padding-top-navbar">
  
  <div class="container">
    <p>View user:</p>
    <p><c:out value="${user.name}" /></p>
    <p><c:out value="${user.email}" /></p>
    <p><c:out value="${user.password}" /></p>
  </div>
</section>

<%@ include file="../partials/footer.jsp" %>
