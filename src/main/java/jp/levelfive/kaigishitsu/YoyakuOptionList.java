package jp.levelfive.kaigishitsu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//各種オプションのオブジェクトのリストを保持するSingltonクラス
/*オプションの種類
 * 部屋　年　月　週　日　開始時刻　終了時刻　予約者　使用目的
 */


public class YoyakuOptionList {
	private static final int OPEN_HOUR = 9;//時 開室
	private static final int CLOSE_HOUR = 21;//時 閉室
	private static final int  UNIT_TIME= 15;//分 単位時間
	private List<YoyakuOption> roomList = new ArrayList<>();
	private List<YoyakuOption> userList = new ArrayList<>();
	private List<YoyakuOption> usageList = new ArrayList<>();
	private List<YoyakuOption> monthList = new ArrayList<>();
	private List<YoyakuOption> weekList = new ArrayList<>();
	//private List<List<Integer>> dayList;
	private List<Integer> dayList = new ArrayList<>();
	private List<Integer> yearList = new ArrayList<>();
	private List<Integer> hourList = new ArrayList<>();
	private List<Integer> minuteList = new ArrayList<>();

	public YoyakuOptionList(){
		int year =Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		//年
		for(int i = 0; i<=1; i++){
			yearList.add(year + i);
		}
		//月
		for(int i=month; i<=month+12 ; i++){
			if(i<=12){
			monthList.add(new YoyakuOption(i,String.valueOf(i)));
			}else{
				monthList.add(new YoyakuOption( i,String.valueOf(i-12) ));
			}
		}
		monthList.add(new YoyakuOption( 0, "毎"));

		//週
		for(int i=1; i<=6; i++){
			monthList.add(new YoyakuOption( i, "第"+i+"週"));
		}

		//日
//		for(int i=Calendar.JANUARY; i<=Calendar.DECEMBER; i++){
//			List<Integer> dayArray = new ArrayList<>();
//			for(int j=1; j<=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);j++){
//				dayArray.add(j);
//			}
//			dayList.add(dayArray);
//		}
		for(int i=1;i<=31;i++){
			dayList.add(i);
		}

		//時
		for(int h=OPEN_HOUR; h<CLOSE_HOUR; h++){
			this.hourList.add(h);
		}
		//分
		for(int m=0; m<60; m = m+UNIT_TIME ){
			this.minuteList.add(m);
		}

	}

	public List<YoyakuOption> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<YoyakuOption> rooms) {
		this.roomList = rooms;
	}
	public List<YoyakuOption> getUserList() {
		return userList;
	}
	public void setUserList(List<YoyakuOption> users) {
		this.userList = users;
	}
	public List<YoyakuOption> getUsageList() {
		return usageList;
	}
	public void setUsageList(List<YoyakuOption> usages) {
		this.usageList = usages;
	}
	public List<Integer> getYearList(){
		return yearList;
	}
	public List<YoyakuOption> getMonthList() {
		return monthList;
	}

	public List<YoyakuOption> getWeekList() {
		return weekList;
	}

//	public List<List<Integer>> getDayList() {
	public List<Integer> getDayList() {
		return dayList;
	}

	public List<Integer> getHourList() {
		return hourList;
	}

	public List<Integer> getMinuteList() {
		return minuteList;
	}

	public void setMonthList(List<YoyakuOption> monthList) {
		this.monthList = monthList;
	}

	public void setWeekList(List<YoyakuOption> weekList) {
		this.weekList = weekList;
	}

	public void setDayList(List<Integer> dayList) {
		this.dayList = dayList;
	}

	public void setYearList(List<Integer> yearList) {
		this.yearList = yearList;
	}

	public void setHourList(List<Integer> hourList) {
		this.hourList = hourList;
	}

	public void setMinuteList(List<Integer> minuteList) {
		this.minuteList = minuteList;
	}
}

//1つのオプションを1個のオブジェクトとして保持するクラス
class YoyakuOption {
	public YoyakuOption(int id, String name){
		this.id = id;
		this.name = name;
	}

	private int id;
	private String name;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}