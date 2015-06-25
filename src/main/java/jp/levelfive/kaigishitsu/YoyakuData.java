package jp.levelfive.kaigishitsu;

public class YoyakuData {
	private int id;
	private int room;
	private int year;
	private int month;
	private int week;
	private int day;
	private int startHour;
	private int startMin;
	private int endHour;
	private int endMin;
	private int user;
	private int usage;
	private String date;
	private String startTime;
	private String endTime;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getDate() {
		return date;
	}
	public void setDate(int year,int month,int day) {
		this.date = year+"-"+month+"-"+day;
	}
	public void setDate(){
		this.date = this.year+"-"+this.month+"-"+this.day;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime() {
		String hour,min;
		if(startHour<10) hour = "0"+startHour;
		else hour=String.valueOf(startHour);
		if(startMin<10) min = "0"+startMin;
		else min=String.valueOf(startMin);
		this.startTime = hour+":"+min;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime() {
		String hour,min;
		if(endHour<10) hour = "0"+endHour;
		else hour=String.valueOf(endHour);
		if(endMin<10) min = "0"+endMin;
		else min=String.valueOf(endMin);
		this.endTime = hour+":"+min;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getStartMin() {
		return startMin;
	}
	public void setStartMin(int startMin) {
		this.startMin = startMin;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public int getEndMin() {
		return endMin;
	}
	public void setEndMin(int endMin) {
		this.endMin = endMin;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getUsage() {
		return usage;
	}
	public void setUsage(int usage) {
		this.usage = usage;
	}
}
