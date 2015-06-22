<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring"
uri="http://www.springframework.org/tags" %>
<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Tye"
	content="text/html; charset=utf-8" />
	<title>会議室予約システム</title>
</head>
<body>
<!-- アカウント管理画面へ -->
<a href="account">アカウント登録</a>

<!-- 予約フォーム -->
<form action="yoyaku" method="post">
	<table>
		<tr>
			<td>部屋:
			<select name="room"><option></option></select>
			<select name="month"></select>月
			<select name="week"></select>週
			<select name="day"></select>日
			<select name="startHour"></select>時
			<select name="startMin"></select>分
			～
			<select name="endHour"></select>時
			<select name="endMin"></select>分
			</td>
			<td>予約者:<select name="user"></select>
			使用目的:<select name="usage">
			</select>
			<input type="submit" value="予約">
			</td>
		</tr>
		<tr>
		</tr>
	</table>
</form>

<!-- カレンダー -->
<!-- forEach文で書く
	コントローラで配列を持ち、javaのカレンダークラスから生成した日付を持たせる -->

<table border="1">
	<tr><td colspan="7">
	<a href="back">
	<<
	</a>
	${year}年
	${month}月
	<a href="forward">
	 >>
	 </a>
	</td></tr>
<!--
<%--
	<c:forEach var="week" begin="0" end="5">
		<tr>
			<c:forEach var="day" begin="0" end="6">
				<td>${calenderMatrix}</td>
			</c:forEach>
		</tr>
	</c:forEach>
 --%>
-->
	<c:forEach var="array" items="${calendarMatrix}" varStatus="i">
		<tr>
			<c:forEach var="index" items="${array}" varStatus="j">
			<td>${index}</td>
			</c:forEach>
		</tr>
	</c:forEach>

</table>

<!-- 一日の予定 -->
<!-- forEach文を使って書く
	48個のセルを反復して生成
	予約が2マス以上にまたがる場合は、colspanで結合する  -->
<p>6月17日の予定</p>
<table border="">
<tr>
<td>会議室</td>
<td>応接室</td>
<td>リフレッシュルーム</td>
</tr>
<c:forEach var="times" begin="1" end="48">
<tr height="10pt">
<c:forEach var="room" begin="1" end="3">
<td> </td>
</c:forEach>
</tr>
</c:forEach>
</table>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
