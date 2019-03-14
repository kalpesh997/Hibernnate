<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="demo" method="post">
		First Name : <input type="text" name="fname"><br><br>
		Last Name : <input type="text" name="lname"><br><br>
		Date : <input type="date" name="date"><br><br>
		Email : <input type="text" name="email"><br><br>
		<input type="submit">
	</form> -->
	<jsp:forward page="/Main?action=listUser" />
</body>
</html>