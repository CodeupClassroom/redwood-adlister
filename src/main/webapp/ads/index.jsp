<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/styles.jsp">
        <jsp:param name="title" value="List of ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />

<div class="container">
    <h1>Lists ads</h1>
</div>

<c:forEach var="ad" items="${ads}">
    <li>${ad.id} - ${ad.userId} - ${ad.title} - ${ad.description} </li>
</c:forEach>

</body>
</html>