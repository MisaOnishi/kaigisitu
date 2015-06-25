package jp.levelfive.kaigishitsu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class YoyakuDAO extends JdbcDaoSupport {
	private String sql = "";
	@Autowired
	DataSource dataSource;

	//TODO 当日の予約リストの取得
	public List<YoyakuData> getYoyakuList(int year,int month, int date) throws DataAccessException {
		RowMapper<YoyakuData> yoyakuRowMapper = new YoyakuRowMapper();
		sql = "select (id, room, startTime, endTime, user, usage ) from reservation where ";
		List<YoyakuData> yoyakuList = getJdbcTemplate().query(sql, yoyakuRowMapper);
		return yoyakuList;
	}

	//TODO 予約の登録
	public int setYoyaku(YoyakuData yoyakuData){
		//重複する予約が無いか検索
		sql="select reId from reservation as R where R.date='"+yoyakuData.getDate()+"' and R.roomId="+yoyakuData.getRoom()+
				" and case when R.startTime<="+yoyakuData.getStartTime()+" then R.endTime>="+yoyakuData.getEndTime()+" when R.startTime>=";

		//重複が無い場合登録
		JdbcTemplate setYoyaku = new JdbcTemplate(dataSource);
		sql="insert into reservation (roomId,week,date,startTime,endTime,userId,usageId) values("+
		yoyakuData.getRoom()+","+
		yoyakuData.getWeek()+",'"+
		yoyakuData.getDate()+"','"+
		yoyakuData.getStartTime()+"','"+
		yoyakuData.getEndTime()+"',"+
		yoyakuData.getUser()+","+
		yoyakuData.getUsage()+")";
		System.out.println();
		System.out.println(sql);
		System.out.println();
		return setYoyaku.update(sql);
	}

	//TODO 予約の削除 アカウントデータからパスワードを取得して照合し、合致すれば削除
	public int cancelYoyaku(YoyakuData yoyakuData){
		JdbcTemplate cancelYoyaku = new JdbcTemplate(dataSource);
		sql="delete from reservation where id=";
		return cancelYoyaku.update(sql);
	}
}

class YoyakuRowMapper implements RowMapper<YoyakuData> {
	private List<YoyakuData> yoyakuList = new ArrayList<YoyakuData>();
	public List<YoyakuData> getResults() {
		return yoyakuList;
	}

	@Override
	public YoyakuData mapRow(ResultSet rs, int rowNum) throws SQLException {
		YoyakuData yoyakuData = new YoyakuData();
		//TODO 取ってくる値と、その変数名を決める
		yoyakuData.setId(rs.getInt("id"));
		yoyakuData.setRoom(rs.getInt(""));
//		yoyakuData.setStartHour(rs.getInt(""));
//		yoyakuData.setStartMin();
//		yoyakuData.setEndHour();
//		yoyakuData.setEndMin();
//		yoyakuData.setUser();
//		yoyakuData.setUsage();
		return yoyakuData;
	}
}

