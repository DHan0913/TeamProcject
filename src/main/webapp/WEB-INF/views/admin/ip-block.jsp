<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Blocked IP Management</title>
</head>
<body>
    <h1>Blocked IP Management</h1>
    <form action="${pageContext.request.contextPath}/admin/block-ip" method="post">
        <input type="text" name="ip" placeholder="IP to block" required>
        <input type="text" name="adminId" placeholder="Admin ID" required>
        <button type="submit">Block IP</button>
    </form>
    <h2>Blocked IPs</h2>
    <ul>
        <c:forEach var="ip" items="${blockedIps}">
            <li>
                <span>${ip.ipAddress}</span>
                <form action="${pageContext.request.contextPath}/admin/unblock-ip" method="post" style="display:inline;">
                    <input type="hidden" name="ip" value="${ip.ipAddress}">
                    <button type="submit">Unblock</button>
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
