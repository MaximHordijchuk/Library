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
            <div class="panel-heading lead text-center">
                Список ваших книг
            </div>
            <div class="panel-body book-quote">
                <blockquote class="blockquote-reverse">
                    Новое новому рознь, и слово «новая» звучит по-разному, в зависимости от того, покупаете ли вы или продаете.
                    <footer>Еріх Марія Ремарк <cite title="Source Title">"Три товариші"</cite></footer>
                </blockquote>
            </div>

            <div class="list-group">
                <c:set var="commitsSize" value="${fn:length(commits)}"/>
                <c:if test="${commitsSize > 0}">
                    <c:forEach var="i" begin="0" end="${commitsSize - 1}">
                        <a class="list-group-item" style="word-wrap:break-word;" href="<c:url value="/book/${commits[i].book.id}"/>">
                            <small class="pull-right gray-text"><c:out value="${commits[i].date}"/></small>
                            <div>
                                <strong><c:out value="${commits[i].book.title}"/> </strong>
                                <span class="label label-success">Прочитано</span>
                                <br>
                                <small class="gray-text"><em>Автори: <c:out value="${commits[i].book.authorsString}"/></em></small>
                                <div class="pull-right">
                                    <span class="glyphicon glyphicon-pencil"></span> <span class="glyphicon glyphicon-trash"></span>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
</div>

<%@ include file="navigation.jsp"%>

<%@ include file="footer.jsp"%>