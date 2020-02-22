<%@ include file="../partials/header.jsp" %>

<section id="top" class="padding-top-navbar">

  <div class="container my-5">

    <form action="/users/new" method="post">
      <h2>
        Edit User
      </h2>

      <label for="name">User Name:</label>
      <input class="form-control" type="text" name="name" size="80" value="<c:out value='${user.name}' />"/>

      <br>

      <label for="email">Email:</label>
      <input class="form-control" type="text" name="email" size="80" value="<c:out value='${user.email}' />"/>

      <br>

      <label for="password">Password:</label>
      <input class="form-control" type="text" name="password" size="80" value="<c:out value='${user.password}' />"/>

      <h4 class="mt-4">Phone(s):</h4>

      <c:forEach var="phone" items="${user.phones}">
        <label for="phone">DDD:</label>
        <input class="form-control" type="text" name="ddd" size="3" value="<c:out value='${phone.ddd}' />"/>
        <label for="phone">Phone:</label>
        <input class="form-control" type="text" name="phone" size="15" value="<c:out value='${phone.number}' />"/>
        <label for="phone">Type:</label>
        <input class="form-control" type="text" name="type" size="30" value="<c:out value='${phone.type}' />"/>

        <br>
      </c:forEach>

      <input type="submit" value="Save" />

    </form>
  </div>
</section>

<%@ include file="../partials/footer.jsp" %>
