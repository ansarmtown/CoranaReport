<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="color:red">
${total}
</div>
<table>
<thead>
<tr>
<th>Country</th>
<th>State</th>
<th>Total Case</th>
</tr>
</thead>
<tbody>
<c:forEach var="stat" items="${stats}">
<tr>
<td>${stat.country}</td>
<td>${stat.state}</td>

<td>${stat.totalCases}</td>
</tr>
</c:forEach>

</tbody>


</table>

</body>
</html>