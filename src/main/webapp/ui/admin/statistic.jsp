<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<body>
  <head>
    <meta charset="UTF-8">
</head>
<h1>Статистика приложения</h1>

<p>Количество активных пользователей: ${activeSessionsCount}</p>
<p>Количество пользователей в приложении: ${userCount}</p>
<p>Количество отправленных сообщений в приложении: ${messagesCount}</p>

</body>
</html>