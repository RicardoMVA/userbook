<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="partials/header.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<section>
  <section class="jumbotron text-center">
    <div class="container">
      <h1>Userbook</h1>
      <p class="lead text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras at elit id urna pellentesque vestibulum vel vitae lorem. Morbi porta ex vel nulla molestie, vitae mollis purus rutrum. Nam vehicula imperdiet molestie. Aliquam vel est sed elit convallis malesuada in nec libero. Nunc nec arcu nisl.</p>
      <p>
        <a href="/users/new" class="btn btn-primary my-2">Register New User</a>
      </p>
    </div>
  </section>

  <div class="album py-3 bg-light">
    <div class="container">
      <div class="row">

        <c:forEach var="user" items="${listUser}">
          <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <img class="user-img" src="<c:out value='${user.imageLocation}' />">
              <div class="card-body">
                <p class="card-text"><strong><c:out value="${user.name}" /></strong></p>
                <p class="card-text"><c:out value="${user.email}" /></p>    
                <p class="card-text">
                  (<c:out value="${user.phones[0].ddd}" />)
                  <c:out value="${user.phones[0].number}" />
                  <c:out value="${user.phones[0].type}" />
                  <c:if test="${fn:length(user.phones) > 1}">
                    <small class="text-muted ml-2">more...</small>
                  </c:if>
                </p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                    <a type="button" class="btn btn-sm btn-outline-secondary" href="/users/view?id=<c:out value='${user.id}' />">View</a>
                    <a type="button" class="btn btn-sm btn-outline-secondary" href="/users/edit?id=<c:out value='${user.id}' />">Edit</a>
                    <input type="hidden" name="userId" value="<c:out value='${user.id}' />">
                    <a type="button" class="btn btn-sm btn-outline-secondary deleteBtn" href="#">Delete</a>
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
