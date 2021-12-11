<%--
  Created by IntelliJ IDEA.
  User: xaosp
  Date: 12/9/2021
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Drug Home Page</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        h1 {
            text-align:center;
            background-color: lightseagreen;

        }

        .btn {

            width: 100%;
        }


    </style>
</head>
<body>
<h1>Drug</h1>

<div class="Container">

    <%--    Lab5. Step2. Creating two text boxes under Header--%>
    <form method="GET">
        <div class="form-group">
            <label for="dcode">Drug Code:</label>
            <input type="text" name="drugcode" class="form-control" id="dcode" value="${dcode}">
        </div>
        <div class="form-group">
            <label for="dname">Drug Name:</label>
            <input type="text" name="drugname" class="form-control" id="dname" value="${dname}">
        </div>
        <div class="form-group">
            <label for="ddesc">Drug Descritiopn:</label>
            <input type="text" name="drugdesc" class="form-control" id="ddesc" value="${ddesc}">
        </div>

        <%--Lab5. Step 3. adding the add button--%>
        <a class="btn btn-success" href="add-todo">Add</a>

    </form>


    <%--    lab5. Step 4. Adding Table with Buttons--%>
<%--        Lab5. Step 13. revise this jsp page to add a View button--%>
        <h1 id="mes">${errorMessage}</h1>
        <div class="container2">
    <h2>Drug</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Drug Code</th>
            <th>Drug Name</th>
            <th>Drug Description</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${todos}" var="todo">

            <tr>

                <td>${todo.drugcode}</td>
                <td>${todo.drugname}</td>
                <td>${todo.drugdesc}</td>

                <td>    <a type="button" class="btn btn-primary"
                           href="update-todo?id=${todo.drugcode}" >Edit</a> </td>

                <td>    <a type="button" class="btn btn-primary"
                           href="delete-todo?id=${todo.drugcode}" >Delete</a> </td>

                <td>    <a type="button" class="btn btn-primary" onmouseout="myFunction()"
                           href="see-todo?id=${todo.drugcode}" >Manufacture</a> </td>

            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>


</div>


<script>
    function myFunction(){
        document.getElementById("mes").innerHTML="";
    }
</script>


</body>
</html>
