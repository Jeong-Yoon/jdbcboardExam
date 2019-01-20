<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2019-01-09
  Time: 오후 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <style>
        #keyword {
            display:inline-table;
        }
        @media (max-width: 768px)  {
            #keyword {
                display:block;
            }
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
<script>
    function PageMove(page){
        location.href = "/board/list?page="+page;
    }

</script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="row">
            <h4>게시판</h4>
                <c:if test="${sessionScope.logininfo == null}">
                <button type="button" onclick="location.href='/login'" class="mybtn" style="float:right;">로그인</button>
                </c:if>
                <c:if test="${sessionScope.logininfo != null}">
                    <b>${sessionScope.logininfo.name}</b>님 반갑습니다.
                    <button type="button" onclick="location.href='/logout'" class="mybtn" style="float:right;">로그아웃</button>
                </c:if>
            </div>
            <div class="table-responsive">
                <table id="mytable" class="table table-bordered table-hover col-sm-12">
                    <thead>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>등록일</th>
                    <th>조회수</th>
                    </thead>

                    <tbody>
                    <form name="boardform" method="post" action="/board/view">
                    <c:forEach items="${boards}" var="board" varStatus="status">
                    <tr>
                        <%--<input type="hidden" name="title" value="${board.title}"/>--%>
                        <%--<input type="hidden" name="name" value="${board.userName}"/>--%>
                        <%--<input type="hidden" name="password" value="${board.password}"/>--%>
                        <%--<input type="hidden" name="content" value="${board.content}"/>--%>
                        <%--<input type="hidden" name="regdate" value="${board.regdate}"/>--%>
                        <%--<td>${status.index + 1}</td>--%>
                        <td>${board.id}</td>
                        <%--<td><a type="submit" href="/board/view" onclick="document.forms['board'].submit();">${board.title}</a></td>--%>
                        <td><a href="/board/view?id=${board.id}">${board.title}</a></td>
                        <%--<input type="hidden" name="password" value="${board.password}">--%>
                        <td>${board.userName}</td>
                        <td>${board.regdate}</td>
                        <td>${board.readCnt}</td>
                    </tr>
                    </c:forEach>
                    </form>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div>
        <form class="form-inline" action="#" method="get">
            <select class="form-control" id="inlineFormInput">
                <option value="all">전체</option>
                <option value="subject">제목</option>
                <option value="content">내용</option>
            </select>

            <label class="sr-only" for="inlineFormInputGroup">Username</label>
            <div id="keyword" class="input-group">
                <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="search...">
            </div>
            <button type="submit" class="mybtn" style="">검색</button>
            <c:if test="${sessionScope.logininfo != null}">
            <button type="button" onclick="location.href='/board/write'" class="mybtn">글쓰기</button>
            </c:if>
        </form>
        <ul class="pagination pull-right">
            <li><a href="javascript:PageMove(${paging.prevPageNo})"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
            <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
                <c:choose>
                    <c:when test="${i eq paging.pageNo}">
                        <li class="active"><a href="javascript:PageMove(${i})">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="javascript:PageMove(${i})">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <%--<li><a href="javascript:PageMove(${paging.firstPageNo})">맨앞으로</a></li>--%>
            <%--<li><a href="javascript:PageMove(${paging.prevPageNo})">앞으로</a></li>--%>

            <%--<li><a href="javascript:PageMove(${paging.nextPageNo})">뒤로</a></li>--%>
            <%--<li><a href="javascript:PageMove(${paging.finalPageNo})">맨뒤로</a></li>--%>

            <%--<li class="active"><a href="#">1</a></li>--%>
            <%--<li><a href="/board/list?page=1">1</a></li>--%>
            <%--<li><a href="/board/list?page=2">2</a></li>--%>
            <%--<li><a href="/board/list?page=3">3</a></li>--%>
            <%--<li><a href="/board/list?page=4">4</a></li>--%>
            <%--<li><a href="/board/list?page=5">5</a></li>--%>
            <li><a href="javascript:PageMove(${paging.nextPageNo})"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
        </ul>
    </div>
    <!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
</div>
<!-- /.modal-dialog -->
</div>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</body>
</html>
