<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="test">
	id<input type="text" name="id" /><br/>
	name<input type="text" name="name" />
	<input type="submit" value="submit"/>

	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
			</tr>
		</thead>
		<tbody>
			<% List list = (List) request.getAttribute("users"); %>
			<% int listSize = list == null ? 0 : list.size(); %>
			<% for(int i = 0; i < listSize; i++) { %>
				<tr>
					<td>${users.get(i).id}</td>
					<td>${users.get(i).name}</td>
				</tr>
			<% } %>
		</tbody>
	</table>
</form>
</body>
</html>