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
	<title>会議室予約システム</title>
</head>
<body>
<!-- アカウント管理画面へ -->
<a href="account">アカウント登録</a>

<!-- 予約フォーム -->
<form action="yoyaku" method="post">
	<table>
		<tr>
			<td>部屋:<select name="room"><option></option></select>
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
<h2>"currentmonth"</h2>
<table border="1">
	<tr>
		<%--<!-- c:forEach item="${list}" var="days"></c:forEach --> --%>
	</tr>
</table>


<table border="0" cellspacing="1" cellpadding="1" bgcolor="#CCCCCC" style="font: 12px; color: #666666;">
<tr>
<td align="center" colspan="7" bgcolor="#EEEEEE" height="18" style="color: #666666;">
<<  2015年6月 >>
</td></tr>
<tr>
<td align="center" width="20" height="18" bgcolor="#FF3300" style="color: #FFFFFF;">日</td>
<td align="center" width="20" bgcolor="#C7D8ED" style="color: #666666;">月</td>
<td align="center" width="20" bgcolor="#C7D8ED" style="color: #666666;">火</td>
<td align="center" width="20" bgcolor="#C7D8ED" style="color: #666666;">水</td>
<td align="center" width="20" bgcolor="#C7D8ED" style="color: #666666;">木</td>
<td align="center" width="20" bgcolor="#C7D8ED" style="color: #666666;">金</td>
<td align="center" width="20" bgcolor="#A6C0E1" style="color: #666666;">土</td>
</tr>
<tr>
<td align="center" height="18" bgcolor="#FFCC99" style="color: #666666;">　</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">1</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">2</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">3</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">4</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">5</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">6</td>
</tr>
<tr>
<td align="center" height="18" bgcolor="#FFCC99" style="color: #666666;">7</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">8</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">9</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">10</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">11</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">12</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">13</td>
</tr>
<tr>
<td align="center" height="18" bgcolor="#FFCC99" style="color: #666666;">14</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">15</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">16</td>
<td align="center" bgcolor="#FF3300" style="color: #FFFFFF;">17</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">18</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">19</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">20</td>
</tr>
<tr>
<td align="center" height="18" bgcolor="#FFCC99" style="color: #666666;">21</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">22</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">23</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">24</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">25</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">26</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">27</td>
</tr>
<tr>
<td align="center" height="18" bgcolor="#FFCC99" style="color: #666666;">28</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">29</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">30</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">　</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">　</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">　</td>
<td align="center" bgcolor="#FFFFFF" style="color: #666666;">　</td>
</tr>
<tr>
<td bgcolor="#FFFFFF" height="18">&nbsp;</td>
<td bgcolor="#FFFFFF">&nbsp;</td>
<td bgcolor="#FFFFFF">&nbsp;</td>
<td bgcolor="#FFFFFF">&nbsp;</td>
<td bgcolor="#FFFFFF">&nbsp;</td>
<td bgcolor="#FFFFFF">&nbsp;</td>
<td bgcolor="#FFFFFF">&nbsp;</td>
</tr>
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
