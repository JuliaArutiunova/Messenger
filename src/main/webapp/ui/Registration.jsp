<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<body>
    <head>
        <meta charset="UTF-8">
    </head>

    <h2>Регистрация</h2>

        <form action="${pageContext.request.contextPath}/api/user", method="POST">
            Имя:<br>
                <input type="text" name="userName" value="${userName}" required>
                <br>
                <br>
            Дата рождения:<br>
                <input type="date" name="bday" value="${birthDate}" required>
                <br>
                <br>
            Логин:<br>
                <input type="text" name="login" value="${login}" required>
                <br>
                <br>
            Пароль:<br>
                <input type="password" name="psw" required>
                <br>
                <br>
            Подтвердите пароля:<br>
                <input type="password" name="confirmPsw" required>
                <br>
                <br>
                <br>
            <input type="submit"  value="Зарегестрироваться">
        </form>

    <c:if test="${not empty errors}">
        <h4>Ошибки заполнения формы:</h4>
            <c:forEach items="${errors}" var="item">
                <p style="color:Red;">${item.getMessage()}</p>
            </c:forEach>
    </c:if>

</body>
</html>