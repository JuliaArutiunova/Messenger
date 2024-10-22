
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<body>
    <head>
        <meta charset="UTF-8">
    </head>
<h2>Вход</h2>

<form action="login", method="POST">
Логин:<br>
<input type="text" name="login">
<br>
Пароль :<br>
<input type="password" name="psw">
<br>
<br>

<button type="submit">Отправить</button>
</form>

<c:if test="${not empty error}">
<jsp:include page="loginError.jsp" />
</c:if>


</body>
</html>