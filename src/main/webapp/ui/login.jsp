
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<body>
    <head>
        <meta charset="UTF-8">
    </head>
<h2>Вход</h2>

    <form action="${pageContext.request.contextPath}/api/login", method="POST">
        Логин:<br>
            <input type="text" name="login" value="${userLogin}">
            <br>
        Пароль :<br>
            <input type="password" name="psw">
            <br>
            <br>
        <button type="submit">Отправить</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color:Red;">${error}</p>
        <a href="${pageContext.request.contextPath}/ui/signUp"> Зарегистрироваться </a>
    </c:if>

</body>
</html>