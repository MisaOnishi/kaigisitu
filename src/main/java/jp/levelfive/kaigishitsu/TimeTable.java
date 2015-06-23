package jp.levelfive.kaigishitsu;


public class TimeTable {
	private int[][] timeTableArray;

	public void TimeTable(){
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
		KaigishitsuDAO dao = new KaigishitsuDAO();

		//取得した予約情報を全て配列にセットする
		this.timeTableArray = timeTableArray;
	}

}
