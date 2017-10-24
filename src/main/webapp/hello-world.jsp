<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
    <%@ include file="/WEB-INF/partials/styles.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/partials/navbar.jsp"%>
<h1>${greeting}</h1>
<%@ include file="/WEB-INF/partials/scripts.jsp"%>
</body>
</html>
