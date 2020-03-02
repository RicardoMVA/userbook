<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../partials/header.jsp" %>

<section>
  <div class="container my-5">

    <div class="row">
      <form class="form" action="/users/edit" id="putForm">

        <div class="col-md-12">
          <h2>Edit User</h2>
        </div>

        <div class="col-md-6">
          <label for="name">User Name:</label>
          <input class="form-control" type="text" name="name"value="<c:out value='${user.name}' />"/>
        </div>

        <div class="col-md-6">
          <label for="email">Email:</label>
          <input class="form-control" type="text" name="email" value="<c:out value='${user.email}' />"/>
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
          <c:forEach var="phone" items="${user.phones}">
            <div id="phoneForm" class="row mt-2">
              <div class="col-2 col-sm-2 col-md-2 ddd-col">
                <label for="ddd">DDD:</label>
                <input class="form-control ddd" type="text" name="ddd" value="<c:out value='${phone.ddd}' />"/>
              </div>

              <div class="col-4 col-sm-3 col-md-4 number-col">
                <label for="number">Number:</label>
                <input class="form-control number" type="text" name="number" value="<c:out value='${phone.number}' />"/>
              </div>

              <div class="col-4 col-sm-4 col-md-6">
                <label for="type">Type:</label>
                <select class="form-control type" name="type" required>
                  <option value="<c:out value='${phone.type}' />" selected><c:out value='${phone.type}' /></option>
                  <option value="Residential">Residential</option>
                  <option value="Cellphone">Cellphone</option>
                  <option value="Professional">Professional</option>
                </select>
              </div>
            </div>
          </c:forEach>
        </div>

        <div class="col-md-12 mt-3">
          <p id="addPhone">Add more phones</p>
        </div>

        <div class="col-md-12 mt-3">
          <input type="submit" value="Save" id="putFormBtn"/>
        </div>

      </form>
    </div>
  </div>
</section>

<%@ include file="../partials/footer.jsp" %>
