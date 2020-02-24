<%@ include file="partials/header.jsp" %>

<section id="top" class="padding-top-navbar">

<div class="container text-center py-5">
  <form class="form-signin" action="/auth/login" method="POST">
    <img class="mb-4" src="#" alt="" width="72" height="72">

    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" name="user" class="form-control" placeholder="Email address" required autofocus>

    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="pwd" class="form-control" placeholder="Password" required>

    <button class="btn btn-lg btn-primary btn-block mt-4" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">© 2020</p>
  </form>
</div>

</section>

<%@ include file="partials/footer.jsp" %>
