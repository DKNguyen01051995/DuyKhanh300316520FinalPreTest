<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drug Edit</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>This page is opened when you click the Edit Button from the Drug HomePage</h1>
    <form method="POST">
        <fieldset class="form-group">
            <label> Drug code :</label>
            <input name="drugcode" type="text" class="form-control" required />

        </fieldset>

        <fieldset class="form-group">
            <label> Drug name :</label>
            <input name="drugname" type="text" class="form-control" required />

        </fieldset>

        <fieldset class="form-group">
            <label> Drug description :</label>
            <input name="drugdesc" type="text" class="form-control" required />

        </fieldset>
        <input class="btn btn-success" type="submit" value="Submit" />
    </form>

</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
