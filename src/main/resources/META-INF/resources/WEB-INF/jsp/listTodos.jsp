<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<div>Welcome to the home page ${name}!</div>
<div>Your Todo list</div>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>description</th>
        <th>target date</th>
        <th> is done?</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${todoList}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>