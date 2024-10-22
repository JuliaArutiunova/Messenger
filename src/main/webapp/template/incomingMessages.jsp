<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<body>
  <head>
    <meta charset="UTF-8">
    <style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
}
th {
  text-align: left;
}
    </style>
</head>
<h4>Входящие сообщения:</h4>
<table style="width:100%">
  <tr>
    <th>От кого</th>
    <th>Текст сообщения</th>
    <th>Дата</th>
  </tr>

 <c:forEach items="${messages}" var="item">
               <tr>
                 <td> ${item.getName()}</td>
                 <td> ${item.getText()}</td>
                 <td> ${formatter.format(item.getTime())}</td>
               </tr>
 </c:forEach>
</table>

</body>
</html>