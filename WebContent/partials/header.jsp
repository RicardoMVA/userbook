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
        <c:choose>
          <c:when test="${sessionScope.user != null}">
            <li class="nav-item">
              <a class="nav-link" href="/users/new"><i class="fas fa-user-edit"></i> New</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/users/view?id=<c:out value='${sessionScope.user.id}' />"><i class="fas fa-user"></i> <c:out value="${sessionScope.user.name}" /></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/auth/logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
            </li>
          </c:when>
          <c:otherwise>
            <li class="nav-item">
              <a class="nav-link" href="/users/new"><i class="fas fa-user-edit"></i> New</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/auth/login"><i class="fas fa-sign-in-alt"></i> Login</a>
            </li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>

<div id="top" class="padding-navbar-top"></div>

<div id="alert-container" class="container fixed-top 
  <c:choose>
    <c:when test='${alert != null}'> 
      floating-alert-display
    </c:when>
    <c:otherwise>
      floating-alert-hide
    </c:otherwise>
  </c:choose>">

  <div id="alert-box" class="alert alert-dismissible show
    <c:if test='${alert != null}'>
      <c:out value='alert-success' />
    </c:if>" 
    role="alert">
    
    <span id="alert-text">
      <c:if test='${alert != null}'>
        <c:out value='${alert}' />
      </c:if>
    </span>
    <button type="button" class="close close-box" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>  
</div>
