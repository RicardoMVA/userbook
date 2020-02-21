<%@ include file="../partials/header.jsp" %>

<section id="top" class="padding-top-navbar">

  <div class="container my-5">

    <form action="new" method="post">
      <h2>
        Add New User
      </h2>

      <label for="name">User Name:</label>
      <input class="form-control" type="text" name="name" size="80"/>

      <br>

      <label for="email">Email:</label>
      <input class="form-control" type="text" name="email" size="80"/>

      <br>

      <label for="password">Password:</label>
      <input class="form-control" type="text" name="password" size="80"/>

      <br>

      <input type="submit" value="Save" />

    </form>
  </div>
</section>

<%@ include file="../partials/footer.jsp" %>
