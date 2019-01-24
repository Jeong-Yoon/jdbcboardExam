<%--

  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2019-01-09
  Time: 오후 3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>view</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <style>
        #article-heading {
            padding:24px; border-bottom:1px solid #ddd;
        }
        .article-subject {
            margin:0px;
            padding:5px;
        }
        .article-name {
            text-align:right;
        }
        .article-name > span {
            padding:0px 5px 0px 5px;
        }
        .article-footer {
            float:right;
        }
        #main-content {
            line-height:25px;
            border:none;
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
<div class="container" style="margin-top:20px;">
    <div class="row-fluid">
        <div class="col-sm-12 col-sm-offset-0 toppad" >
            <div class="panel panel-default">
                <div id="article-heading">
                    <h3 class="article-subject">${board.title}</h3>

                    <div class="article-name">
                        <span>${board.userName}</span>
                        <span>${board.regdate}</span>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td id="main-content">${board.content}</td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="article-footer">
                                <button onclick="location.href='/board/list'" class="mybtn">목록</button>
                                <%--<a href="/board/list" class="btn btn-primary">목록</a>--%>
                                <c:if test="${board.userId != sessionScope.logininfo.id}">
                                <button type="button" onclick="location.href='/rewrite?id=${board.id}'" class="mybtn" data-target="#check">답글</button>
                                </c:if>
                                <c:if test="${board.userId == sessionScope.logininfo.id}">
                                <button type="button" onclick="location.href='/board/modify?id=${board.id}'" class="mybtn" data-target="#check">수정</button>
                                    <button type="button" onclick="location.href='/board/delete?id=${board.id}'" class="mybtn" data-target="#check">삭제</button>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="check" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h3 class="modal-title" id="lineModalLabel">확인</h3>
            </div>
            <div class="modal-body">

                <!-- content goes here -->
                <form>
                    <div class="form-group">
                        <label for="InputName">이름</label>
                        <input type="text" class="form-control" id="InputName" placeholder="이름">
                    </div>
                    <div class="form-group">
                        <label for="InputPassword">비밀번호</label>
                        <input type="password" class="form-control" id="inputPassword" placeholder="비밀번호">
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <div class="btn-group btn-group-justified" role="group" aria-label="group button">
                    <div class="btn-group" role="group">
                        <button type="button" id="saveImage" class="btn btn-default btn-hover-green" data-action="save" role="button">전송</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
