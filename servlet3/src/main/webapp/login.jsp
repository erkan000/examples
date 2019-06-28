<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Test Dispatcher</title>
</head>
<body>
	<p>&nbsp;</p>

	<form action="dispatch" method="post">

		<table align="center" border="1">

			<tr>
				<th colspan="2" align="center">Welcome</th>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="user"></td>
			</tr>
			<tr>
				<td>Pass:</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Login">
				</td>
			</tr>

		</table>

	</form>
</body>
</html>