<%--
  User: max
  Date: 16.03.15
  Time: 13:56
  Have fun!
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp"%>

<div class="col-xs-12 col-sm-9 col-lg-15">
    <p class="pull-right visible-xs">
        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
    </p>
    <div class="row" style="word-wrap:break-word;">
        <div class="panel panel-body" id="book-info">
            <div class="page-header">
                <p class="pull-right gray-text"><c:out value="${commit.date}"/></p>
                <h1><c:out value="${commit.book.title}"/></h1>
                <p class="gray-text"><em>Автори: <c:out value="${commit.book.authorsString}"/></em></p>
            </div>
            <p class="lead"><c:out value="${commit.comment}"/></p>
        </div>
    </div>
</div>

<%@ include file="navigation.jsp"%>

<%@ include file="footer.jsp"%>
