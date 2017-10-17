<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- class Example  { --%>
<%! int counter = 0; %> <!-- instance variable -->
<%! List<String> languages = Arrays.asList("Java", "Javascript", "CSS", "SQL", "HTML"); %>
<% request.setAttribute("languages", languages); %>
<c:if test="${param.reset != null}">
    <% counter = 0; %>
</c:if>

<%-- public void doGet(request, response) --%>
<% counter += 1; %>
<% request.setAttribute("i", counter); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello world from a JSP file</title>
    <%@ include file="partials/styles.jsp" %>
</head>
<body>
    <%@ include file="partials/navbar.jsp"%>

    <h1>Hello, <%= request.getParameter("name") %>!</h1>
    <h2>Hello, ${param.name}!</h2>

    <p>I know the following languages</p>
    <ul>
        <c:forEach var="language" items="${languages}">
            <c:choose>
                <c:when test="${language.equals('Java')}">
                    <li><strong>${language.toUpperCase()}</strong></li>
                </c:when>
                <c:when test="${language.equals('SQL')}">
                    <li><em>${language.toUpperCase()}</em></li>
                </c:when>
                <c:otherwise>
                    <li>${language}</li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ul>

    <% out.print("<p>more text</p>"); %>
    <h1>The current count is <%= counter %>.</h1>
    <h1>The current count is ${i + 10}.</h1>
    <h1>The current count is ${param.i + 10}.</h1>

    <%@ include file="partials/scripts.jsp"%>
</body>
</html>
<%--    } doGet --%>
<%-- } --%>
