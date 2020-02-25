<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../partials/header.jsp" %>

  <div class="container my-5">

    <div class="row">
      <form class="form" action="/users/new" method="post">

        <div class="col-md-12">
          <h2>Add New User</h2>
        </div>

        <div class="col-md-6">
          <label for="name">User Name:</label>
          <input class="form-control" type="text" name="name" size="80"/>
        </div>

        <div class="col-md-6">
          <label for="email">Email:</label>
          <input class="form-control" type="text" name="email" size="80"/>
        </div>

        <div class="col-md-6">
          <label for="password">Password:</label>
          <input class="form-control" type="password" name="password" size="80"/>
        </div>

        <div class="col-md-6">
          <label for="password">Confirm Password:</label>
          <input class="form-control" type="password" name="passwordConfirm" size="80"/>
        </div>

        <div class="col-md-12">
          <h4 class="mt-4">Phone(s):</h4>
        </div>

        <div class="col-2 col-sm-2 col-md-1 ddd-col">
          <label for="phone">DDD:</label>
          <input class="form-control ddd" type="text" name="ddd" size="3"/>
        </div>

        <div class="col-4 col-sm-3 col-md-2 phone-col">
          <label for="phone">Phone:</label>
          <input class="form-control phone" type="text" name="phone" size="15"/>
        </div>

        <div class="col-4 col-sm-4 col-md-2">
          <label for="type">Type:</label>
          <select class="form-control type" name="type" required>
            <option value="" disabled selected>Select...</option>
            <option>Residential</option>
            <option>Cellphone</option>
            <option>Professional</option>
          </select>
        </div>

        <div class="col-md-12 mt-5">
          <input type="submit" value="Save" />
        </div>

      </form>
    </div>
  </div>
</section> <!-- closes section that is in header.jsp -->

<%@ include file="../partials/footer.jsp" %>
