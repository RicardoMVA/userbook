<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../partials/header.jsp" %>

<section>
  <div class="container my-5">

    <div class="row">
      <form class="form" action="/users/new" method="post">

        <div class="col-md-12">
          <h2>Add New User</h2>
        </div>

        <div class="col-md-6">
          <label for="name">User Name:</label>
          <input class="form-control" type="text" name="name"/>
        </div>

        <div class="col-md-6">
          <label for="email">Email:</label>
          <input class="form-control" type="text" name="email"/>
        </div>

        <div class="col-md-6">
          <label for="password">Password:</label>
          <input class="form-control" type="password" name="password"/>
        </div>

        <div class="col-md-6">
          <label for="password">Confirm Password:</label>
          <input class="form-control" type="password" name="passwordConfirm"/>
        </div>

        <div class="col-md-12">
          <h4 class="mt-4">Phone(s):</h4>
        </div>
        
        <div id="phonesList" class="col-12 col-sm-10 col-md-6">
          <div id="phoneForm" class="row mt-2">
            <div class="col-2 col-sm-2 col-md-2 ddd-col">
              <label for="ddd">DDD:</label>
              <input class="form-control ddd" type="text" name="ddd"/>
            </div>

            <div class="col-4 col-sm-3 col-md-4 number-col">
              <label for="number">Number:</label>
              <input class="form-control number" type="text" name="number"/>
            </div>

            <div class="col-4 col-sm-4 col-md-6">
              <label for="type">Type:</label>
              <select class="form-control type" name="type" required>
                <option value="" disabled selected>Select...</option>
                <option>Residential</option>
                <option>Cellphone</option>
                <option>Professional</option>
              </select>
            </div>
          </div>
        </div>

        <div class="col-md-12 mt-3">
          <p id="addPhone">Add more phones</p>
        </div>

        <div class="col-md-12 mt-3">
          <input type="submit" value="Save" />
        </div>

      </form>
    </div>
  </div>
</section>

<%@ include file="../partials/footer.jsp" %>
