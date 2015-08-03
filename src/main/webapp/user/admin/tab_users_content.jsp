<%@ page import="com.frolov.testing.dao.DaoFactory" %>
<%@ page import="com.frolov.testing.dao.jdbc.dao.JdbcUserDao" %>
<%@ page import="com.frolov.testing.entity.user.BaseUser" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 class="md-headline">Список пользователей</h1>
<%
    final JdbcUserDao userDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcUserDao.class);
    final Iterable<BaseUser> all = userDao.getAll();
    request.setAttribute("userList", all);
%>

<md-list>
    <md-subheader> <%--class="md-no-sticky"--%>
        <%--<md-list-item>--%>
        <div layout="row" layout-fill>
            <span flex>Ф. И. О.</span>
            <span flex>E-mail</span>
            <span flex>Тип</span>
        </div>
        <%--<%@ include file="/tabs_content/user_list_item_menu_component.html" %>--%>
        <%--</md-list-item>--%>
    </md-subheader>
    <md-divider></md-divider>
    <c:forEach var="user" items="${userList}">
        <md-list-item> <%--class="md-3-line"--%>
            <div layout="row" layout-fill> <%--class="md-list-item-text"--%>
                <span flex>${user.fullName}</span>
                <span flex>${user.email}</span>
                <span flex>${user.type}</span>
            </div>
            <%--<%@ include file="/tabs_content/user_list_item_menu_component.html" %>--%>
        </md-list-item>
        <md-divider></md-divider>
    </c:forEach>
</md-list>