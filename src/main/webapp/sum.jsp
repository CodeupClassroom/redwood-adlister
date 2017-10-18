<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sum 2 numbers</title>
    <%@ include file="partials/styles.jsp" %>
</head>
<body>
<%@ include file="partials/navbar.jsp"%>
<h3>${param.num1} + ${param.num2} = ${sum}</h3>
<%@ include file="partials/scripts.jsp"%>
</body>
</html>
