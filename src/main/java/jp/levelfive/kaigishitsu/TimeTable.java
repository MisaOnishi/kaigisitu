package jp.levelfive.kaigishitsu;

import java.util.List;

public class TimeTable {
	private int[][] timeTableArray;
	private YoyakuDAO yoyakuDAO;

	public TimeTable(){
		for(int[] array : timeTableArray){
			for(int i : array){
				i=0;
			}
		}
	}

	public int[][] getTimeTableArray() {
		return timeTableArray;
	}

	public void setTimeTableArray(int year, int month, int date) {
		List<YoyakuData> yoyakuList = yoyakuDAO.getYoyakuList(year,month,date);
		//取得した予約情報を全て配列にセットする
		this.timeTableArray = timeTableArray;
	}

}
