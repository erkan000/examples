<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
</head>
 
<body>
<s:form>
    <h2>WELCOME  <s:property value="username" />!</h2>
    <s:a href="user.jsp"> Add User </s:a>
</s:form>
</body>
</html>