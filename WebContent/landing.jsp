<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/estilo.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container-xl">
    <a class="navbar-brand" href="/">Userbook</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Create</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Read</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Update</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Delete</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<section id="top" class="margin-top-navbar">

  <section class="jumbotron text-center">
    <div class="container">
      <h1>Userbook</h1>
      <p class="lead text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras at elit id urna pellentesque vestibulum vel vitae lorem. Morbi porta ex vel nulla molestie, vitae mollis purus rutrum. Nam vehicula imperdiet molestie. Aliquam vel est sed elit convallis malesuada in nec libero. Nunc nec arcu nisl.</p>
      <p>
        <a href="#" class="btn btn-primary my-2">Register</a>
        <a href="#" class="btn btn-secondary my-2">View All</a>
      </p>
    </div>
  </section>

  <div class="album py-3 bg-light">
    <div class="container">
      <div class="row">

        <c:forEach var="user" items="${listUser}">
          <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
              <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
              <div class="card-body">
                <p class="card-text"><c:out value="${user.id}" /></p>
                <p class="card-text"><c:out value="${user.name}" /></p>
                <p class="card-text"><c:out value="${user.email}" /></p>
                <p class="card-text"><c:out value="${user.password}" /></p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                  </div>
                  <small class="text-muted">9 mins</small>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>

      </div>
    </div>
  </div>
</section>

<nav class="navbar navbar-expand-sm navbar-light bg-light navbar-bottom">
  <div class="collapse navbar-collapse justify-content-md-center">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="#top">Voltar ao topo</a>
        </li>
      </ul>
    </div>
</nav>

<script src="resources/js/jquery-3.4.1.slim.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/script.js"></script>

</body>
</html>