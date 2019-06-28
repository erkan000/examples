<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>XSS Test Form</title>
</head>
<body>

	<br>
	<form action="post" method="POST">
	
		Input: <input type="text" name="input">
		<br />
		
		<button type="submit">Send !</button>
		<br />
		
		Dawn XSS Input variable is = ${input}

	</form>
</body>
</html>