<%--
  Created by IntelliJ IDEA.
  User: max
  Date: 12.02.15
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/resources/favicon.ico"/>">

    <%--Scripts--%>
    <%--<script src="<s:url value="/resources/js/application.js"/>"></script>--%>

    <title>Ваша сторінка</title>

    <!-- Bootstrap core CSS -->
    <link href="<s:url value="/resources/bootstrap-dist/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../resources/css/home.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Library</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">Про нас</a></li>
                <li><a href="#contact">Контакти</a></li>
            </ul>
        </div>
        <!-- /.nav-collapse -->
    </div>
    <!-- /.container -->
</nav>
<!-- /.navbar -->

<div class="container">

    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9 col-lg-15">
            <p class="pull-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
            </p>
            <div class="row">
                <%--<div class="col-xs-6 col-lg-6">--%>
                <%--<div class="col-xs-6 col-lg-5">
                    <h2>Прочитані книги</h2>
                    <div class="list-group" id="book-info-button">
                        <c:forEach var="book" items="${books}">
                            <a href="#/book/${book.id}" class="list-group-item">
                                <h4 class="list-group-item-heading">${book.title}</h4>
                                <p class="list-group-item-text">${book.authorsString}</p>
                            </a>
                        </c:forEach>
                    </div>
                    &lt;%&ndash;<p><a class="btn btn-default" id="book-info-button" href="/book1/6" role="button" >View details &raquo;</a></p>&ndash;%&gt;
                </div>--%>
                <%--<div class="well pull-left" style="min-width: 340px; margin: 5px; padding: 8px 0;">
                    <ul class="nav nav-list">
                        <li class="nav-header">Заголовок</li>
                        <li class="active"><c:forEach var="book" items="${books}">
                            <a href="#/book/${book.id}">${book.title} (${book.authorsString})</a>
                        </c:forEach></li>
                    </ul>
                </div>--%>
                <div class="panel panel-default" id="book-table">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Список ваших книг</div>
                    <div class="panel-body">
                        <p>Тут будуть якісь цитати з книг</p>
                    </div>

                    <!-- Table -->
                    <table class="table table-striped table-bordered table-hover" id="book-table">
                        <thead>
                        <tr class="info">
                            <th>#</th>
                            <th class="clickable">Назва книги</th>
                            <th>Автори</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" begin="0" end="4">
                            <tr class="success clickable" data-href="/book/${books[i].id}">
                                <th scope="row">${i}</th>
                                <td>${books[i].title}</td>
                                <td>${books[i].authorsString}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%--<div class="col-xs-6 col-lg-6" id="book-info"></div>--%>
            </div>
        </div>

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
            <div class="list-group">
                <a href="#" class="list-group-item active">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
            </div>
        </div>
    </div>
    <!--/row-->

    <hr>

    <footer>
        <p>&copy; Library 2015</p>
    </footer>

</div>
<!--/.container-->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/sammy-0.7.6.min.js"/>"></script>
<script src="../../resources/bootstrap-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/application.js"/>"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../resources/js/ie10-viewport-bug-workaround.js"></script>

<script src="<s:url value="/resources/js/offcanvas.js"/>"></script>
</body>
</html>