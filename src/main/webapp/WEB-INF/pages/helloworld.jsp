<%--
  Created by IntelliJ IDEA.
  User: Chekireva
  Date: 24.04.2019
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloworld</title>

</head>
<body>
<%--<h1>${greeting}</h1>--%>

<table>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>
                <c:out value="${person.id}"/>
            </td>
            <td>
                <c:out value="${person.name}"/>
            </td>
            <%--<td>--%>
                <%--<a href="<c:url value="/delete/${user.id}"/>" >Delete user</a>--%>
            <%--</td>--%>
        </tr>
    </c:forEach>
    <c:if test="${empty persons}">
        no users added yet.
    </c:if>
</table>

<%--<a href="<c:url value="/add"/>" >Add new user</a>--%>

</body>
</html>
