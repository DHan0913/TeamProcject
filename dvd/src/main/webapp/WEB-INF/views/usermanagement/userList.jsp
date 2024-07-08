<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
    <h1>User List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>User No</th>
                <th>Username</th>
                <th>Birth</th>
                <th>Email</th>
                <th>Password</th>
                <th>Reg Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.userNo}</td>
                    <td>${user.username}</td>
                    <td>${user.birth}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.regdate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
