<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Userbook</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/style.css" rel="stylesheet">
<link href="/resources/css/all.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <div class="container-xl">
    <a class="navbar-brand" href="/"><i class="far fa-address-book"></i> Userbook</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/"><i class="fas fa-home"></i> Home<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/users/new"><i class="fas fa-plus"></i> Create</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><i class="fas fa-glasses"></i> Read</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><i class="fas fa-redo"></i> Update</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><i class="fas fa-times"></i> Delete</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
