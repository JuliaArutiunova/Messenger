<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="by.it_academy.jd2.entity.UserRole" %>
<!DOCTYPE html>
<html>
<body>
    <head>
        <meta charset="UTF-8">
    </head>

    <h2>Пользователь: ${userName}</h2>
        <form action="${pageContext.request.contextPath}/api/logout", method="POST">
            <button type="submit">Выйти</button>
        </form>

        <c:if test="${user.getRole() eq UserRole.ADMIN}">
            <br>
            <a href="${pageContext.request.contextPath}/api/admin/statistics">
                <button>Смотреть статистику приложения</button>
            </a>
        </c:if>
<br><br>
    <fieldset>
    <legend><h4>Написать сообщение</h4></legend>

    <form action="${pageContext.request.contextPath}/api/message", method="POST">
        Кому:<br>
            <select name="to" required>
                    <c:forEach items="${userList}" var="user">
                        <option value="${user.login}">${user.name}</option>
                    </c:forEach>
                </select>
            <br>
        Сообщение :<br>
            <textarea name="text" id="txtpole" cols="70" rows="5" required> </textarea><br>
            <br>

        <button type="submit">Отправить</button>
    </form>
    </fieldset>
    <p style="color:Red;"> ${error}</p>
    <p style="color:Green;"> ${report}</p>
    <br>

    <c:choose>
        <c:when test="${not empty messages}">
            <jsp:include page="/ui/user/incomingMessages.jsp" />
        </c:when>
        <c:otherwise>
            <h3>Нет входящих сообщений</h3>
        </c:otherwise>
    </c:choose>

</body>
</html>