<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<h1>Messenger</h1>

    <a href="${pageContext.request.contextPath}/ui/login">
        <button>Войти </button>
    </a>
    <br><br>
    <a href="${pageContext.request.contextPath}/ui/signUp">
        <button>Зарегистрироваться</button>
    </a>
</body>
</html>