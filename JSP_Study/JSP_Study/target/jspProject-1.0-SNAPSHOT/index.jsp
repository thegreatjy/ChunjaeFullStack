<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css"
          integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<div class="container">
    <div class="form-group row pull-right">
        <div class="col-xs-8">
            <input type="text" class="form-control" id="userName" onkeyup="searchFunction();" size="20"/>
        </div>
        <div class="col-xs-2">
            <button type="button" class="btn btn-primary" onclick="searchFunction();">검색</button>
        </div>
    </div>
    <table class="table" style="text-align: center; border: 1px solid #ddd; table-layout: fixed;">
        <thead>
        <tr>
            <th style="background-color: #fafafa; text-align: center;">이름</th>
            <th style="background-color: #fafafa; text-align: center;">나이</th>
            <th style="background-color: #fafafa; text-align: center;">성별</th>
            <th style="background-color: #fafafa; text-align: center;">이메일</th>
        </tr>
        </thead>
        <tbody id="ajaxTable">
            <tr>
                <td>이지연</td>
                <td>25</td>
                <td>여자</td>
                <td>jy@gmail.com</td>
            </tr>
        </tbody>
    </table>
</div>


</body>
</html>