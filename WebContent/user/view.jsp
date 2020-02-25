<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../partials/header.jsp" %>

  <div class="container">
    <p>View user:</p>
    <p><c:out value="${user.name}" /></p>
    <p><c:out value="${user.email}" /></p>
    <p><c:out value="${user.password}" /></p>

    <a type="button" class="btn btn-primary" href="/users/edit?id=<c:out value='${user.id}' />">Edit user</a>
  </div>
</section> <!-- closes section that is in header.jsp -->

<%@ include file="../partials/footer.jsp" %>
