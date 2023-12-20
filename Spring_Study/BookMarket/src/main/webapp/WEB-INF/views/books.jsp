<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/17/23
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
  <title>도서목록</title>
  <!--
  <link href="c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
  -->

  <!-- bootstrap 4 -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  <!-- Bootstrap CDN
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    -->
</head>
<body>
<nav class="navbar navbar-expand  navbar-dark bg-dark">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="./home">Home</a>
    </div>
  </div>
</nav>

<div class="jumbotron">
  <div class="container">
    <h1 class="display-3">도서 목록</h1>
  </div>
</div>

<div class="container">
  <div class="row" align="center">
    <c:forEach items="${bookList}" var="book">
      <div class="col-md-4">
        <h3>${book.name}</h3>
        <p>${book.author}
          <br> ${book.publisher} | ${book.releaseDate}
        <p align=left>${fn:substring(book.description, 0, 100)}...
        <p>${book.unitPrice}원
        <p><a href="<c:url  value="/books/book?id=${book.bookId}"/>" class="btn btn-Secondary" role="button">상세정보 &raquo;</a>
      </div>
    </c:forEach>
  </div>
  <hr>

  <footer>
    <p>&copy; BookMarket</p>
  </footer>
</div>

</body>
</html>
