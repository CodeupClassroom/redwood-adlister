<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/styles.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
${sessionScope.get("firstAd")}
<div class="container">
    <h1>Viewing your profile ${sessionScope.user}.</h1>
</div>

</body>
</html>
