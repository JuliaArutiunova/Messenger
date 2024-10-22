<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<body>
  <head>
    <meta charset="UTF-8">
</head>

<c:forEach items="${errors}" var="item">
<p style="color:Red;">${item.getMessage()}</p>
</c:forEach>

</body>
</html>