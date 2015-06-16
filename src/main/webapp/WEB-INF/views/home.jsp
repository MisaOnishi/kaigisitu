<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Tye"
	content="text/html; charset=utf-8" />
	<title>Home</title>
</head>
<body>
<h1>Spring MVC</h1>
<P>  ${message}</P>
<form:form modelAttribute="command">
<table>
	<tr>
	<td>Name:</td>
	<td><form:input path="name" /><br>
	<span style="color:red">${name_err.defaultMessage}</span></td>
	</tr>
	<tr>
	<td>Mail:</td>
	<td><form:input path="mail" /><br>
	<span style="color:red">${mail_err.defaultMessage}</span></td>
	</tr>
	<tr>
	<td	colspan="2"><input type="submit"
		value="Click"/></td>
	</tr>
</table>
</form:form>
</body>
</html>
