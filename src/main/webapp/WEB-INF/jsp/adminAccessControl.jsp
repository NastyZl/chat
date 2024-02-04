<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Управление доступом пользователей</title>
    <style>
          <%@include file="../css/style.css"%>
    </style>
</head>
<body>
<div align = "center">
    <a href="chat?command=chat">Назад</a>
        <div align="center">
            <table>
                <caption>Список пользователей</caption>
                <thread>
                    <tr>
                        <th>login</th>
                        <th>password</th>
                        <th>name</th>
                        <th>userType</th>
                        <th>status</th>
                        <th>edit access</th>
                    </tr>
                </thread>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.login}</td>
                        <td>${user.password}</td>
                        <td>${user.name}</td>
                        <td>${user.userType}</td>
                        <c:choose>
                            <c:when test="${user.isOnline()==true}">
                                <td>online</td>
                                <br />
                            </c:when>
                            <c:otherwise>
                                <td>offline</td>
                                <br />
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${user.isPermissionToSendMessage()==true}">
                                <td> <button class="button" type="submit" onclick="checkPermission('${user.login}','${user.isPermissionToSendMessage()}')" id="permission">on</button></td>
                                <br />
                            </c:when>
                            <c:otherwise>
                                <td> <button class="button" type="submit" onclick="checkPermission('${user.login}', '${user.isPermissionToSendMessage()}')" id="permission">off</button></td>
                                <br />
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
<script>
    <%@include file="../js/adminAccessControl.js"%>
</script>
</html>
