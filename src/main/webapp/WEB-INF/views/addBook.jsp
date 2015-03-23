<%--
  User: max
  Date: 16.03.15
  Time: 14:38
  Have fun!
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp"%>

<div class="col-xs-12 col-sm-9 col-lg-15">
    <p class="pull-right visible-xs">
        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
    </p>

    <div class="row">
        <form id="bookForm" method="post" action="<c:url value="/book/add"/>">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <h2>Додати нову книгу</h2>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-xs-8">
                        <label class="control-label">Назва книги</label>
                        <input type="text" class="form-control" name="title" placeholder="Кобзар" autofocus/>
                    </div>

                    <div class="col-xs-4 selectContainer">
                        <label class="control-label">Статус</label>
                        <select class="form-control btn-success" name="status">
                            <option class="btn-default" value="finished">Прочитав</option>
                            <option class="btn-default" value="processing">Читаю</option>
                            <option class="btn-default" value="queue">Хочу прочитати</option>
                            <option class="btn-default" value="stopped">Перестав читати</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-xs-8">
                    <label class="control-label">Опис книги</label>
                        <textarea id="description" name="description" rows="5"
                                class="form-control"
                                placeholder="«Кобзар» — назва збірки поетичних творів Тараса Григоровича Шевченка."></textarea>
                    </div>
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Додати книгу</button>
                <button type="button" class="btn btn-default">Відмінити</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="navigation.jsp"%>

<%@ include file="footer.jsp"%>