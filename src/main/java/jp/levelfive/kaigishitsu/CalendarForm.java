package jp.levelfive.kaigishitsu;

import java.util.Calendar;

public class CalendarForm {
	private static int currentYear;
	private static int currentMonth;
	private static int date;
	private static final int TODAY = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	static {
		System.out.println("\n CalendarForm static CALL\n");
		setCurrentYear(Calendar.getInstance().get(Calendar.YEAR));
		setCurrentMonth(Calendar.getInstance().get(Calendar.MONTH));
	}
	private int year;
	private int month;
	private String[][] calendarMatrix = new String[6][7];

	/*
	 * デフォルトのカレンダーobjを生成
	 */
	public CalendarForm() {
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.month = Calendar.getInstance().get(Calendar.MONTH);
		this.setDate(TODAY);
		CalendarForm.setCurrentYear(year);
		CalendarForm.setCurrentMonth(month);
		setCalendarMatrix(this.year, this.month);
	}

	/*
	 * 年月を指定してカレンダーobjを生成
	 */
	public CalendarForm(int year, int month) {
		this.year = year;
		this.month = month;
		setCalendarMatrix(year, month);
	}

	public static int getCurrentYear() {
		return currentYear;
	}

	public static void setCurrentYear(int currentYear) {
		CalendarForm.currentYear = currentYear;
	}

	public static int getCurrentMonth() {
		return currentMonth;
	}

	public static void setCurrentMonth(int currentMonth) {
		CalendarForm.currentMonth = currentMonth;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		CalendarForm.date = date;
	}

	public static void setCurrentMonthForward(){
		if(currentMonth >=11){
			currentYear++;
			currentMonth=0;
		}else{
			currentMonth++;
		}
	}

	public static void setCurrentMonthBack(){
		if(currentMonth <=0){
			currentYear--;
			currentMonth=11;
		}else{
			currentMonth--;
		}
	}

	public static int getToday() {
		return TODAY;
	}

	public void setNextMonth(int currentYear, int currentMonth){
		if(currentMonth >=11){
			currentYear++;
			currentMonth=0;
		}else{
			currentMonth++;
		}
	}

	public void setPrevMonth(int currentYear, int currentMonth){
		if(currentMonth <=0){
			currentYear--;
			currentMonth=11;
		}else{
			currentMonth--;
		}
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

	public String[][] getCalendarMatrix() {
		return calendarMatrix;
	}

	public void setCalendarMatrix(int year, int month) {
		this.year = year;
		this.month = month;
		generateCalendar();
//		for (String[] array : calendarMatrix) {
//			for (String index : array) {
//				System.out.println(index);
//			}
//		}
	}

	private void generateCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(this.year, this.month, 1);
		int startDay = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.MONTH, +1);
		calendar.add(Calendar.DATE, -1);
		int lastDate = calendar.get(Calendar.DAY_OF_MONTH);

		for (int row = 0, date = 1; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				if (row == 0 && col < startDay - 1) {
					calendarMatrix[row][col] = "　";
				} else if (date > lastDate) {
					calendarMatrix[row][col] = "　";
				} else {
					calendarMatrix[row][col] = String.valueOf(date);
					date++;
				}
			}
		}
	}
}
