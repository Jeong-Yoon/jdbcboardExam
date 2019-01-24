<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2019-01-18
  Time: 오전 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Join</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <style>
        .well
        {
            padding: 35px;
            padding-left: 30px;
            box-shadow: 0 0 10px #666666;
            margin: 4% auto 0;
            width: 450px;
        }

        body
        {
            background-color:  #dedede;
        }

        .input-group-addon
        {
            background-color: #f6f6f6;
            color: #495057;
        }

        .btn-block{
            padding: .5rem!important
        }
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

<!------ Include the above in your HEAD tag ---------->

<%--<form action="/join"method="post" onsubmit="return(validate());">--%>
<form action="/join" method="post">
    <div class="container-fluid">
        <div class="row">
            <div class="well center-block">
                <div class="well-header">
                    <h3 class="text-center text-success"> Join </h3>
                    <hr>
                </div>

                <%--<div class="row">--%>
                    <%--<div class="col-md-12 col-sm-12 col-xs-12">--%>
                        <%--<div class="form-group">--%>
                            <%--<div class="input-group">--%>
                                <%--<div class="input-group-addon">--%>
                                    <%--<i class="glyphicon glyphicon-user"></i>--%>
                                <%--</div>--%>
                                <%--<input type="text" placeholder="E-mail" name="id" class="form-control" required>--%>

                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <div class="row">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-envelope"></i>
                                </div>
                                <input type="email" class="form-control" name="email" placeholder="E-Mail" required>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </div>
                                <input type="text" placeholder="Name" name="name" class="form-control" required>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </div>
                                <input type="password" minlength="4" maxlength="20" placeholder="password1" name="passwd1" class="form-control" required>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </div>
                                <input type="password" minlength="4" maxlength="20" placeholder="password2" name="passwd2" class="form-control" required>
                            </div>
                        </div>
                    </div>
                </div>

                <%--<div class="row">--%>
                    <%--<div class="col-md-12 col-xs-12 col-sm-12">--%>
                        <%--<div class="form-group">--%>
                            <%--<div class="input-group">--%>
                                <%--<div class="input-group-addon">--%>
                                    <%--<i class="glyphicon glyphicon-phone"></i>--%>
                                <%--</div>--%>
                                <%--<input type="text" minlength="10" maxlength="12" class="form-control" name="txtmobile" placeholder="Mobile No.">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>


                <%--<div class="row">--%>
                    <%--<div class="col-md-12 col-xs-12 col-sm-12">--%>
                        <%--<div class="form-group">--%>
                            <%--<div class="input-group">--%>
                                <%--<div class="input-group-addon">--%>
                                    <%--<i class="glyphicon glyphicon-list-alt"></i>--%>
                                <%--</div>--%>
                                <%--<textarea class="form-control" name="txtadd" placeholder="Address"></textarea>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="row">--%>
                    <%--<div class="col-md-12 col-xs-12 col-sm-12">--%>
                        <%--<div class="form-group">--%>
                            <%--<div class="input-group">--%>
                                <%--<div class="input-group-addon">--%>
                                    <%--<i class="glyphicon glyphicon-calendar"></i>--%>
                                <%--</div>--%>
                                <%--<input type="text" name="dob" placeholder="Date Of Birth" class="form-control" id="datepicker">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <div class="row widget">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <button class="mybtn btn-warning btn-block"> login </button>
                    </div>
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <button class="mybtn btn-warning btn-block"> Submit </button>
                    </div>
                </div>
            </div>
        </div>
    </div>


</form>
</body>
</html>
