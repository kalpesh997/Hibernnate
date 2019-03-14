<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"   integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="   crossorigin="anonymous"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.1/css/bootstrap-datepicker3.min.css">
<script>
$( document ).ready(function() {
    $("#from-datepicker").datepicker({ 
        format: 'dd-MM-yyyy'
    });
}); 
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="MainController" method="post">
			<table>
    	<tr>
    		<td> User ID : 
    		<td><input type="text" readonly="readonly" name="userid" value="<c:out value="${user.id}" />" /> <tr /> 
        <tr>
        	<td> First Name :
         	<td> <input type="text" name="fname" value="<c:out value="${user.fname}" />" /> <tr /> 
        <tr>
        	<td> Last Name :
        	<td> <input type="text" name="lname" value="<c:out value="${user.lname}" />" /> <tr /> 
        <tr>
        	<td> DOB : 
        	<td> <input type="text" id="from-datepicker" name="date" value="<fmt:formatDate pattern="dd-MM-yyyy" value="${user.date}" />" /><tr /> 
        <tr>
        	<td> Email : 
        	<td> <input type="text" name="email" value="<c:out value="${user.email}" />" /> <tr /> 
        <tr>
        	<td colspan=2> <input type="submit" value="Submit" />
        	</tr>
    </table>
		</form>
</body>
</html>