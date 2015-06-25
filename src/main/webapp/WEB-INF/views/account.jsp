<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>アカウント管理画面</title>
</head>
<body>
<form:form modelAttribute="signIn">
	名前、E-mailアドレス、パスワードを入力してください。<br>
	名前:
	<form:input path="name"/>
	<span style="font-size:10px; color:grey">　全角　１文字～２０文字</span>
	<span style="color:red">${name_err.defaultMessage}</span>
	<br>
	E-mail:
	<form:input path="email"/>
	<span style="font-size:10px; color:grey">半角英数字</span>
	<span style="color:red">${mail_err.defaultMessage}</span>
	<br>
	パスワード：
	<form:input type="password" path="password"/>
	<span style="font-size:10px; color:grey" >　半角　数字４文字</span>
	<span style="color:red">${password_err.defaultMessage}</span>
	<br>
	<input type="submit" value="登録"/>
	<c:if test="${message=='success'}">
		<script type="text/javascript">
			window.confirm("アカウントを登録しました")
		</script>
	</c:if>
	<c:if test="${message='fail'}">
		<script type="text/javascript">
			window.confirm("アカウントの登録に失敗しました")
		</script>
	</c:if>
</form:form>
<br>
<a href="./" >ホームページに戻る</a>
</body>
</html>