<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../partials/header.jsp" %>

<section>
  <div class="container">
    <div class="card shadow mt-4">
      <div class="card-body user-card">
        <div class="row">
          <div class="col-md-6">
              <img class="user-img-detail" src="<c:out value='${user.imageLocation}' />">
          </div>
          
          <div class="col-md-6">
            <h3 class="card-text mb-4"><strong><c:out value="${user.name}" /></strong></h3>
            <p class="card-text"><strong>Email: </strong><c:out value="${user.email}" /></p>
            <p class="card-text"><strong>Password: </strong><c:out value="${user.password}" /></p>
            <p class="card-text"><strong>Phones: </strong></p>
            <c:forEach var="phone" items="${user.phones}">
              <p class="card-text">(<c:out value="${phone.ddd}" />)
              <c:out value="${phone.number}" />
              <c:out value="${phone.type}" /></p>
            </c:forEach>
            
            <a type="button" class="btn btn-primary" href="/users/edit?id=<c:out value='${user.id}' />">Edit user</a>          
          </div>                    
        </div>
      </div>
    </div>
  </div>
</section>

<%@ include file="../partials/footer.jsp" %>
