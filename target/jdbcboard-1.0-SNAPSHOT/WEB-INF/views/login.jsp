<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2019-01-18
  Time: 오전 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>login</title>
    <meta charset="utf-8">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.1/animate.css">

    <style>

        .mybtn {
            -moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
            -webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
            box-shadow:inset 0px 1px 0px 0px #ffffff;
            background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffffff), color-stop(1, #f6f6f6));
            background:-moz-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
            background:-webkit-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
            background:-o-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
            background:-ms-linear-gradient(top, #ffffff 5%, #f6f6f6 100%);
            background:linear-gradient(to bottom, #ffffff 5%, #f6f6f6 100%);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#f6f6f6',GradientType=0);
            background-color:#ffffff;
            -moz-border-radius:6px;
            -webkit-border-radius:6px;
            border-radius:6px;
            border:1px solid #dcdcdc;
            display:inline-block;
            cursor:pointer;
            color:#666666;
            font-family:Arial;
            font-size:15px;
            font-weight:bold;
            padding:6px 24px;
            text-decoration:none;
            text-shadow:0px 1px 0px #ffffff;
        }
        .mybtn:hover {
            background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #f6f6f6), color-stop(1, #ffffff));
            background:-moz-linear-gradient(top, #f6f6f6 5%, #ffffff 100%);
            background:-webkit-linear-gradient(top, #f6f6f6 5%, #ffffff 100%);
            background:-o-linear-gradient(top, #f6f6f6 5%, #ffffff 100%);
            background:-ms-linear-gradient(top, #f6f6f6 5%, #ffffff 100%);
            background:linear-gradient(to bottom, #f6f6f6 5%, #ffffff 100%);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f6f6f6', endColorstr='#ffffff',GradientType=0);
            background-color:#f6f6f6;
        }
        .mybtn:active {
            position:relative;
            top:1px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well login-box">
                <form action="/login" method="post">
                    <legend>Login</legend>
                    <div class="form-group">
                        <label for="email">E-mail</label>
                        <input value='' id="email" name="email" placeholder="E-mail" type="text" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="passwd">Password</label>
                        <input id="passwd" name="passwd" value='' placeholder="Password" type="password" class="form-control" />
                    </div>
                    <div class="form-group text-center">
                        <button type="button" onclick="location.href='/join'" class="mybtn">join</button>
                        <input type="submit" class="mybtn btn-success btn-login-submit" value="Login" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
