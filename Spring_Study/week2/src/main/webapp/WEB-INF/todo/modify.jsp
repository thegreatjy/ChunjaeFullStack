`<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Modify</title>
</head>
<body>
    <form id="form1" method="post" action="/todo/modify">
        <div>
            <input type="text" name="tno" value="${dto.tno}" readonly>
        </div>

        <div>
            <input type="text" name="title" value="${dto.title}" >
        </div>

        <div>
            <input type="date" name="dueDate" value="${dto.dueDate}">
        </div>

        <div>
            <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} >
        </div>

        <div>
            <button type="submit">Modify</button>
        </div>
    </form>

    <form id="form2" action="/todo/remove" method="post">
        <input type="hidden" name="tno" value="${dto.tno}" readonly>
        <div>
            <button type="submit">Remove</button>
        </div>
    </form>
</body>
</html>