<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all users</title>
    <%@ include file="partials/styles.jsp" %>
</head>
<body>
<%@ include file="partials/navbar.jsp"%>
<ul>
<c:forEach var="user" items="${users}">
    <li>
        Name: ${user.name}, email: ${user.email}
    </li>
</c:forEach>
</ul>
<%@ include file="partials/scripts.jsp"%>
</body>
</html>
