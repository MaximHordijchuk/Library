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
    <div class="row">
        <div class="panel panel-default well" id="book-info">
            <c:if test="${isSelectedBook}">
                <h2><c:out value="${selectedBook.title}"/></h2>
                <p><em>Автори: <c:out value="${selectedBook.authorsString}"/></em></p>
                <p><c:out value="${selectedBook.description}"/></p>
            </c:if>
            <c:if test="${!isSelectedBook}">
                <h2>Про книгу</h2>
                <p>Оберіть книгу зі списку в лівій частині, щоб подивитися опис.</p>
            </c:if>
        </div>
    </div>
</div>

<%@ include file="navigation.jsp"%>

<%@ include file="footer.jsp"%>
