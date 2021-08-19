<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 8/18/2021
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <form method="POST">
        <div class="form-group">
            <label for="clientno">Client No:</label>
            <input type="text" name="clientno" class="form-control" id="clientno" value="${todos.clientno}">
        </div>
        <div class="form-group">
            <label for="clientname">Client Name:</label>
            <input type="text" name="clientname" class="form-control" id="clientname" value="${todos.clientname}">
        </div>
        <div class="form-group">
            <label for="loanamount">Loan Amount:</label>
            <input type="text" name="loanamount" class="form-control" id="loanamount" value="${todos.loanamount}">
        </div>
        <div class="form-group">
            <label for="years">Number of Years:</label>
            <input type="text" name="years" class="form-control" id="years" value="${todos.years}">
        </div>
        <div class="form-group">
            <label for="loantype">Saving Type:</label>
            <select id="loantype" name="loantype" class="form-control">
                <option id="bus" name="business" value="Business">Business</option>
                <option id="per" name="personal" value="Personal">Personal</option>
            </select>
        </div>
        <input class="btn btn-success" type="submit" value="Submit" />
    </form>

</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>

