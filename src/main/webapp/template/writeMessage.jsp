<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<body>
    <head>
        <meta charset="UTF-8">
    </head>
<h3>Пользователь: ${userName}</h3>
<jsp:include page="exit.jsp" />

<h2>Написать сообщение</h2>

<form action="message", method="POST">
Кому:<br>
<input type="text" name="to" required>
<br>
Сообщение :<br>
<textarea name="text" id="txtpole" cols="70" rows="5" required> </textarea><br>
<br>

<button type="submit">Отправить</button>
</form>
<br>

<c:choose>
    <c:when test="${not empty messages}">
<jsp:include page="incomingMessages.jsp" />
    </c:when>
    <c:otherwise>
        <h3>Нет входящих сообщений</h3>
    </c:otherwise>
</c:choose>

</body>
</html>