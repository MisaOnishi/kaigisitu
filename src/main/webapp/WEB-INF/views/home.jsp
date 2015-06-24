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
<link rel="stylesheet" href="home.css" type="text/css">
<title>会議室予約システム</title>
</head>

<body>
	<!-- アカウント管理画面へ -->
	<a href="account">アカウント登録</a>

	<!-- 予約フォーム -->
	<div class="reserveForm">
		<form action="yoyaku" method="post">
			<table class="reserveTable">
				<tr>
					<!-- 各選択肢はデータベースから候補を取得して、forEach文で並べる -->
					<td>部屋：<select name="room">
							<option></option>
					</select>
					<select name="month">
					</select> 月 <select name="week">
					</select> 週 <select name="day">
					</select> 日 <select name="startHour">
						</select> 時 <select name="startMin">
						</select> 分 ～ <select name="endHour"></select> 時
						<select name="endMin">
						</select> 分
					</td>
					<td rowspan="2"><input type="submit" value="予約" /></td>
				</tr>
				<tr>
					<td>予約者：<select name="user"></select> 使用目的：<select
						name="usage"></select>
					</td>
				</tr>
			</table>
		</form>
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
