<%--
  Created by IntelliJ IDEA.
  User: xaosp
  Date: 12/10/2021
  Time: 1:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <title>Title</title>
</head>
<body>

<div class="container">
    <h1>Manufacture available under the ${manuname}</h1>

    <h1>${manucode}</h1>

    <table class="table table-stripped">
        <thead>
        <tr>
            <th>Manufacture Code</th>
            <th>Manufacture Name</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach items="${todos1}" var="todo">

            <tr>
                <td>${todo.manucode}</td>
                <td>${todo.manuname}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>


    <form method="Post">
        <input class="btn btn-back" type="submit" value="Submit" />
    </form>


</div>

</body>
</html>
