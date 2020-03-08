<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="partials/header.jsp" %>

<section>
  <div class="container">
    <h2 class="mb-4"><i class="fas fa-exclamation-triangle"></i> Oops! An error has occurred:</h2>
    <p class="mb-5"><c:out value="${error}" /></p>
    <p>Please try again or contact our developer team.</p>
  </div>
</section>

<%@ include file="partials/footer.jsp" %>