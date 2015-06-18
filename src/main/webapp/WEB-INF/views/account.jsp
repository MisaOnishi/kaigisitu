<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>アカウント管理画面</title>
</head>
<body>
<form:form modelAttribute="signIn">
	${message}<br>
	<form:input path="name"/>
	<span style="color:red">${name_err.defaultMessage}</span>
	<br>
	<form:input type="password" path="password"/>
	<span style="color:red">${password_err.defaultMessage}</span>
	<br>
	<input type="submit" value="登録"/>
</form:form>
<br>
<a href="./" >ホームページに戻る</a>

</body>
</html>