<%@ include file="partials/header.jsp" %>

<section id="top" class="padding-top-navbar">

  <section class="jumbotron text-center">
    <div class="container">
      <h1>Userbook</h1>
      <p class="lead text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras at elit id urna pellentesque vestibulum vel vitae lorem. Morbi porta ex vel nulla molestie, vitae mollis purus rutrum. Nam vehicula imperdiet molestie. Aliquam vel est sed elit convallis malesuada in nec libero. Nunc nec arcu nisl.</p>
      <p>
        <a href="#" class="btn btn-primary my-2">Register</a>
        <a href="#" class="btn btn-secondary my-2">View All</a>
      </p>
    </div>
  </section>

  <div class="album py-3 bg-light">
    <div class="container">
      <div class="row">

        <c:forEach var="user" items="${listUser}">
          <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
              <div class="card-body">
                <p class="card-text"><c:out value="${user.name}" /></p>
                <p class="card-text"><c:out value="${user.email}" /></p>
                <p class="card-text"><c:out value="${user.password}" /></p>
                <c:forEach var="phone" items="${user.phones}">
                  <p class="card-text">
                    (<c:out value="${phone.ddd}" />)
                    <c:out value="${phone.number}" />
                    <c:out value="${phone.type}" />
                  </p>
                </c:forEach>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                    <a type="button" class="btn btn-sm btn-outline-secondary" href="/users/view?id=<c:out value='${user.id}' />">View</a>
                    <a type="button" class="btn btn-sm btn-outline-secondary" href="/users/edit?id=<c:out value='${user.id}' />">Edit</a>
                    <input type="hidden" name="userId" value="<c:out value='${user.id}' />">
                    <a type="button" class="btn btn-sm btn-outline-secondary deleteBtn">Delete</a>
                  </div>
                  <small class="text-muted">9 mins</small>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>

      </div>
    </div>
  </div>
</section>

<%@ include file="partials/footer.jsp" %>
