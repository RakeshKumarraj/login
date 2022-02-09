<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>result</title>
</head>
<body>
<h2>All Registration</h2>
<table border="1">
 <tr>
    <th>id </th>
    <th>name</th>
    <th>city </th>
    <th>email</th>
    <th>mobile </th>
    <th>delete</th>
     <th>Update</th>
</tr>
<%
  ResultSet result= (ResultSet)request.getAttribute("result");
       while(result.next()){
%>


<tr>
    <td><%=result.getInt(1) %> </td>
    <td><%=result.getString(2) %></td>
    <td><%=result.getString(3) %></td>
    <td><%=result.getString(4) %></td>
    <td><%=result.getString(5) %></td>
    <td><a href ="delete?email=<%=result.getString(4)%>">delete</a></td>
    <td><a href ="Update?email=<%=result.getString(4)%>&mobile=<%=result.getString(5) %>">Update</a></td>
    
</tr>

<%} %>
</table>
</body>
</html>