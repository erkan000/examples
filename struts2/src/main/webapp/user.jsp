<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>User Form</title>
</head>
 
<body>
<h2>User Form</h2>
 
<s:form action="user.action" method="post">
    <s:textfield name="name" key="name" size="20" />
    <s:textfield name="age" key="age" size="20" />
    <s:textfield name="email" key="email" size="20" />
    <s:textfield name="telephone" key="telephone" size="20" />
    <s:submit method="addCustomer" key="label.add.user" align="center" />
</s:form>
</body>
</html>