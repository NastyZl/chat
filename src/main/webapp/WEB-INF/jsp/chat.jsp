<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="icon" href="data:,">
    <head>
        <title>Чат</title>
        <style>
            <%@include file="../css/style.css"%>
        </style>
    </head>
    <body>
        <div align="center">
            <div class="nav"">
                <a href="chat?command=logout">Выход</a>
                <c:if test="${user.userType == 'ADMIN'}">
                    <a href="chat?command=show_admin_page">Настройки доступа</a>
                </c:if>
            </div>
            <div align="left" class="chat">
                <c:forEach items="${messages}" var="message">
                    <div class = "msg">
                        <b> ${message.user.name}</b>(${message.user.userType}): ${message.message}
                    </div>
                </c:forEach>
            </div>
            <div>
                <form method="post" action="chat?command=show_chat_page">
                    <input type="text" name="message" placeholder="Введите сообщение"/>
                    <button type="submit">Отправить</button>
                </form>
            </div>
        </div>
    </body>
</html>