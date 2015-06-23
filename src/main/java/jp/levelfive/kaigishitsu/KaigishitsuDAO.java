package jp.levelfive.kaigishitsu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class KaigishitsuDAO extends JdbcDaoSupport {
	private String sql = "";
	private static final Logger logger = LoggerFactory.getLogger(KaigishitsuDAO.class);
	@Autowired
	DataSource dataSource;

	//TODO 当日の予約リストの取得
	public List<YoyakuData> getYoyakuList(DateFormat date) throws DataAccessException {
		RowMapper<YoyakuData> yoyakuRowMapper = new YoyakuRowMapper();
		sql = "select (id, room, startHour, startMin, endHour, endMin ) from reservation where date";
		List<YoyakuData> yoyakuList = getJdbcTemplate().query(sql, yoyakuRowMapper);
		return yoyakuList;
	}

	//TODO 予約の登録
	public int setYoyaku(YoyakuData yoyakuData){
		JdbcTemplate setYoyaku = new JdbcTemplate(dataSource);
		sql="insert into reservation(room,year,month,week,date, startTime, endTime,userId) values(";

		return setYoyaku.update(sql);
	}

	//TODO 予約の削除 アカウントデータからパスワードを取得して照合し、合致すれば削除
	public int cancelYoyaku(int id, String password){
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
		return yoyakuData;
	}
}

