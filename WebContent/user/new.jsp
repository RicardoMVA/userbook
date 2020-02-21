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

      <h4 class="mt-4">Phone(s):</h4>

      <label for="phone">DDD:</label>
      <input class="form-control" type="text" name="ddd" size="3"/>
      <label for="phone">Phone:</label>
      <input class="form-control" type="text" name="phone" size="15"/>
      <label for="phone">Type:</label>
      <input class="form-control" type="text" name="type" size="30"/>

      <br>

      <input type="submit" value="Save" />

    </form>
  </div>
</section>

<%@ include file="../partials/footer.jsp" %>
