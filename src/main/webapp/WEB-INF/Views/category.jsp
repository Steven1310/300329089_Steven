<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 8/18/2021
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Loan Records</title>
    <style>
        h1 {
            text-align:center;
            background-color: cyan;

        }

        .btn {

            width: 100%;
        }


    </style>

</head>
<body>
<h1>Loan Records</h1>



<div class="container">

    <div class="container2">
        <h2>the following are the laon records</h2>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Clint number</th>
                <th>Clint name</th>
                <th>Loan  amount</th>
                <th>Years</th>
                <th>Loan Type</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${todos}" var="todo">

                <tr>
                    <td>${todo.clientno}</td>
                    <td>${todo.clientname}</td>
                    <td>${todo.loanamount}</td>
                    <td>${todo.years}</td>
                    <td>${todo.loantype}</td>

                    <td>    <a type="button" class="btn btn-primary"
                               href="update-todo?id=${todo.clientno}" >Edit</a> </td>



                    <td>    <a type="button" class="btn btn-primary"
                               onclick="showMessage(${todo.clientno});" >Delete</a> </td>
                    <td>    <a type="button" class="btn btn-primary"
                               href="ammortz-todo?id=${todo.clientno}" >Amortization Table</a> </td>

                </tr>


            </c:forEach>
            </tbody>
        </table>
        <a type="button" class="btn btn-primary"
           href="add-todo?id=${todo.clientno}" >Add</a>
    </div>

</div>

<script>
    function showMessage(clientno)
    {
        debugger;
        if(confirm("Are you sure to delete record")){
            window.location="delete-todo?id="+clientno;
        }
    }





</script>

</body>
</html>


