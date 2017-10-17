<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- class Example  { --%>
<%! int counter = 0; %> <!-- instance variable -->
<%! List<String> languages = new ArrayList<>(); %>
<%-- public void doGet(...) --%>
<% counter += 1; %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello world from a JSP file</title>
    <%@ include file="partials/styles.jsp" %>
</head>
<body>
    <%@ include file="partials/navbar.jsp"%>

    <h1>Hello, world!</h1>
    <h1>The current count is <%= counter %>.</h1>

    <%@ include file="partials/scripts.jsp"%>
</body>
</html>
<%--    } doGet --%>
<%-- } --%>
