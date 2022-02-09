<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<h2>Update your mobile here </h2>
<form action="Update" method="post">
<pre>
email <input type="text" name ="email" value="<%=request.getAttribute("email")%>" readonly/>
mobile  <input type="text" name ="mobile" value="<%=request.getAttribute("mobile")%>"/>
<input type="submit" value="update">
</pre>
</form>
</body>
</html>