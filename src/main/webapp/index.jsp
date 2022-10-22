<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Files</title>
</head>
<body>
<h2>FileSystem</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <tr><th>Name</th><th>Sourse</th><th></th></tr>
    <c:forEach var="files" items="${directorys}">
        <tr><td>${files.name}</td>
            <td>${files.src}</td>
            <td>
                <a href='<c:url value="/edit?name=${files.name}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${files.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
</body>
</html>