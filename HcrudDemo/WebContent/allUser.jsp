<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
        <thead>
            <tr>            
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Email</th>
                <th colspan="2">Action</th>                               
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allusers}" var="user">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${fn:toUpperCase(user.fname)}" /></td>
                    <td><c:out value="${user.lname}" /></td>
                    <td><fmt:formatDate pattern="dd-MMM-yyyy" value="${user.date}" /></td>
                    <td><c:out value="${user.email}" /></td>   
                    <td><a href="Main?action=edit&userId=<c:out value="${user.id}"/>" >Update</a></td>
                    <td><a href="Main?action=delete&userId=<c:out value="${user.id}"/>" >Delete</a></td>                
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="Main?action=insert">Add User</a></p>
</body>
</html>