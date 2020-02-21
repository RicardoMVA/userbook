<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
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
          <a class="nav-link" href="/new">Create</a>
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

<p>New</p>

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