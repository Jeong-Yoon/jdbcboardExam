<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2019-01-09
  Time: 오후 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>write</title>
    <style>
        .my-form {
            margin-top: 20px;
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
<main class="my-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">글쓰기</div>

                    <div class="card-body">

                        <div class="card-body-center">
                            <form name="my-form" action="/board/write" method="post">
                                <div class="form-group row">
                                    <label class="col-md-2 col-form-label text-md-right">작성자</label>
                                    <div class="col-md-9">
                                        <label>${sessionScope.logininfo.name} </label>
                                    </div>
                                </div>

                                <%--<div class="form-group row">--%>
                                    <%--<label for="password"--%>
                                                 <%--class="col-md-2 col-form-label text-md-right">암호</label>--%>
                                    <%--<div class="col-md-9">--%>
                                        <%--<input type="password" id="password" class="form-control" name="password">--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <div class="form-group row">
                                    <label for="title" class="col-md-2 col-form-label text-md-right">제목</label>
                                    <div class="col-md-9">
                                        <input type="text" id="title" class="form-control" name="title">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="content" class="col-md-2 col-form-label text-md-right">내용</label>
                                    <textarea class="col-md-9" id="content" name="content" rows="8"></textarea>
                                </div>

                                <div class="d-flex flex-row-reverse">
                                    <div class="d-flex flex-row-reverse">


                                        <div class="p-2">
                                            <button type="submit" class="mybtn">
                                                등록
                                            </button>
                                        </div>

                                        <div class="p-2">
                                            <button type="button" onclick="location.href='/board/list'" class="mybtn">
                                                목록
                                            </button>
                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
