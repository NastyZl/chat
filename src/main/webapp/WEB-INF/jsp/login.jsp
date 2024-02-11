<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<link rel="icon" href="data:,">
<head>
    <title>Вход в Чат</title>
</head>
<style>
    h4 {
        color: red;
    }
</style>
<body>
<div align="center">
    <form method="POST" action="chat?command=login">
        <table>
            <tr>
                <td><label for="loginInput">Логин</label></td>
                <td><input id="loginInput" type="text" name="loginInput" value="${loginInput}"/></td>
            </tr>
            <tr>
                <td><label for="passwordInput">Пароль</label></td>
                <td><input id="passwordInput" type="password" name="passwordInput" value=""/></td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Войти</button>
                </td>
            </tr>
        </table>
        <h4>${errorLoginMessage}</h4>
    </form>
</div>
</body>
</html>