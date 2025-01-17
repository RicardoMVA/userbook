<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="partials/header.jsp" %>

<section>  
  <div class="container text-center py-3">
    <form class="form-signin" action="/auth/login" method="POST">
      <img class="logo-img mb-4" src="/resources/images/userbook.jpg" alt="notebook and pen">

      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="text" name="userEmail" class="form-control custom-form mb-2" placeholder="Email address" minlength="4" required>

      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" name="password" class="form-control custom-form" placeholder="Password" required>

      <button class="btn btn-lg btn-primary btn-block mt-4" type="submit">Sign in</button>

      <p class="mt-5">Don't have an account yet? Click <a href="/users/new">here</a> to register!</p>

      <p class="mt-5 mb-3 text-muted">Created by Ricardo Valença, 2020</p>
    </form>
  </div>
</section>

<%@ include file="partials/footer.jsp" %>
