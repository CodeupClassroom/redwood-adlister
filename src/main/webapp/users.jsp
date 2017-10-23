<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all users</title>
    <%@ include file="partials/styles.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/partials/navbar.jsp"%>
<ul>
<c:forEach var="user" items="${users}">
    <li>
        Name: ${user.username}, email: ${user.email}
    </li>
</c:forEach>
</ul>
<%@ include file="/WEB-INF/partials/scripts.jsp"%>
</body>
</html>
