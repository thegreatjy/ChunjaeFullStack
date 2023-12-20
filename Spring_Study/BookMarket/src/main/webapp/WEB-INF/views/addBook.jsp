<%--
  Created by IntelliJ IDEA.
  User: thegreatjy
  Date: 12/19/23
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>도서 등록</title>

  <!-- bootstrap 4 -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

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
    <h1 class="display-3">도서 등록</h1>
  </div>
</div>

<div class="container">

  <form:form modelAttribute="NewBook" class="form-horizontal" >
    <fieldset>
      <legend>${addTitle}</legend>
      <div class="form-group row">
        <label class="col-sm-2 control-label">도서 ID</label>
        <div class="col-sm-3">
          <form:input  path="bookId"  class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >도서명</label>
        <div class="col-sm-3">
          <form:input  path="name"  class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >가격</label>
        <div class="col-sm-3">
          <form:input  path="unitPrice" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >저자</label>
        <div class="col-sm-3">
          <form:input  path="author" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >상세정보</label>
        <div class="col-sm-5">
          <form:textarea  path="description" cols="50" rows="2" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >출판사</label>
        <div class="col-sm-3">
          <form:input  path="publisher" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >분야</label>
        <div class="col-sm-3">
          <form:input path="category" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >재고수 </label>
        <div class="col-sm-3">
          <form:input path="unitsInStock" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >출판일</label>
        <div class="col-sm-3">
          <form:input path="releaseDate" class="form-control"/>
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 control-label" >상태</label>
        <div class="col-sm-3">
          <form:radiobutton path="condition" value="New" /> New
          <form:radiobutton path="condition" value="Old" /> Old
          <form:radiobutton path="condition" value="E-Book" />E-Book
        </div>
      </div>
      <div class="form-group row">
        <div class="col-sm-offset-2 col-sm-10" >
          <input type="submit" class="btn btn-primary" value ="등록"/>
        </div>
      </div>
    </fieldset>
  </form:form>
  <hr>
  <footer>
    <p>&copy; BookMarket</p>
  </footer>
</div>
</body>
</html>
