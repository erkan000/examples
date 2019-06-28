<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 First App</title>
</head>
 
<body>
<h2>Struts-2 Login App</h2>

<s:actionerror />

<s:form action="login.action" method="post">
   	<s:textfield name="username" key="label.username" size="20" tooltip="admin/admin"/>
   	<s:password name="password" key="label.password" size="20" />
    <s:submit method="execute" key="label.login" align="center" />
</s:form>
</body>
</html>