<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Tye" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/home.css" type="text/css">
<title>会議室予約システム</title>
</head>
<body>
	<!-- アカウント管理画面へ -->
	<a href="account">アカウント登録</a>

	<!-- 予約フォーム -->
	<div class="reserveForm">
		<form:form modelAttribute="yoyaku">
			<table class="reserveTable">
				<tr>
					<!-- 各選択肢はデータベースから候補を取得して、forEach文で並べる -->
					<td>
					場所：<form:select path="room" items="${roomList}" itemLabel="name" itemValue="id"/>
					<form:select path="year" items="${yearList}"  name="year"/>
					 年　
					<form:select path="month" items="${monthList}" itemLabel="name" itemValue="id"
					 onChange="setDays" id="month">
					 	<form:option value="${month}"></form:option>
					 </form:select>
					 月　
					<form:select path="week" items="${weekList}"  itemLabel="name" itemValue="id"/>
					 週　
					<form:select path="day" items="${dayList}" name="setDays" id="day">
					<form:option value=" "></form:option>
					<%--<!--<c:forEach var="i" begin="1" end="31" varStatus="days">
						<form:option value="${days.i}">${days.i}</form:option>
					</c:forEach>-->--%>
					</form:select>
					 日　
					<form:select path="startHour" items="${hourList}"  name="startHour"/>
					 時　
					<form:select path="startMin" items="${minuteList}" name="stratMinute"/>
					 分　～
					<form:select path="endHour" items="${hourList}" name="endHour"/>
					 時　
					<form:select path="endMin" items="${minuteList}" name="endMinute"/>
					 分　
					</td>
					<td rowspan="2"><input type="submit" value="予約" /></td>
				</tr>
				<tr>
					<td>予約者：
					<form:select path="user" items="${userList}" itemLabel="name" itemValue="id" name="user"/>
					 使用目的：
					 <form:select path="usage" items="${usageList}" itemLabel="name" itemValue="id" name="usage"/>
					</td>
				</tr>
			</table>
			<c:if test="${message=='success'}">
				<script type="text/javascript">
					window.confirm("予約しました")
				</script>
			</c:if>
			<c:if test="${message='fail'}">
				<script type="text/javascript">
					window.confirm("予約に失敗しました")
				</script>
			</c:if>
		</form:form>
	</div>
	<!-- カレンダー -->
	<!-- forEach文で書く
	コントローラで配列を持ち、javaのカレンダークラスから生成した日付を持たせる -->
	<div class="calendarForm">
		<table class="calendar">
			<tr>
				<td colspan="7" align="center"><a href="back"> << </a> ${year}年
					${month}月 <a href="forward"> >> </a> <br>
					<a href="./" style="font-size: 10px">元の月へ戻る</a></td>
			</tr>
			<tr>
				<td id="sunday">日</td>
				<td>月</td>
				<td>火</td>
				<td>水</td>
				<td>木</td>
				<td>金</td>
				<td id="saturday">土</td>
			</tr>
			<c:forEach var="array" items="${calendarMatrix}">
				<tr>
					<c:forEach var="index" items="${array}" varStatus="day">
						<c:choose>
							<c:when test="${day.index ==0}">
								<td id="sunday">
									<a href="${index}">${index}</a>
								</td>
							</c:when>
							<c:when test="${day.index ==6}">
								<td id="saturday">
									<a href="${index}">${index}</a>
								</td>
							</c:when>
							<c:otherwise>
								<td>
									<a href="${index}">${index}</a>
								</td>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- 一日の予定 -->
	<!-- forEach文を使って書く
	48個のセルを反復して生成
	予約が2マス以上にまたがる場合は、colspanで結合する  -->
	<div class="timeTableForm">
		<table class="timeTable">
			<tr>
				<th colspan="4">${month} 月 ${date} 日の予定</th>
			</tr>
			<tr>
				<td></td>
				<td>会議室</td>
				<td>応接室</td>
				<td>リフレッシュルーム</td>
			</tr>
			<c:forEach var="i" begin="0" end="47" varStatus="time">
				<tr height="15pt">
					<td id="timescale">
					<c:if test="${time.index%4==0}">
						　${time.index/4 +9}　</c:if>　
					</td>
					<c:forEach var="j" begin="0" end="2" varStatus="room">
						<td id="column"> </td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
