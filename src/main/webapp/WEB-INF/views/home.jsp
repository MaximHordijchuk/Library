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

        <div class="panel panel-default" id="book-panel">
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
                <c:forEach var="i" begin="0" end="${fn:length(books) - 1}">
                    <tr class="success clickable" data-href="/book/${books[i].id}">
                        <th scope="row">${i + 1}</th>
                        <td><c:out value="${books[i].title}"/></td>
                        <td><c:out value="${books[i].authorsString}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--<div class="col-xs-6 col-lg-6" id="book-info"></div>--%>
    </div>
</div>

<%@ include file="navigation.jsp"%>

<%@ include file="footer.jsp"%>