package jp.levelfive.kaigishitsu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class YoyakuOptionDAO extends JdbcDaoSupport{
	private String sql = "";
	@Autowired
	DataSource dataSource;
	YoyakuOption options = new YoyakuOption();

	//TODO 選択肢の取得
	public YoyakuOption getYoyakuOptions() throws DataAccessException{
		RowMapper<String> stringRowMapper = new StringOptionRowMapper();

		sql = "select (id, name) from reservation where date";
		List<String> list =  getJdbcTemplate().query(sql, stringRowMapper);
		options.setMonthList(list);
		options.setWeekList(list);
		options.setUserList(list);
		options.setUsageList(list);
		options.setWeekDayList(list);

		return null;
	}

}
class StringOptionRowMapper implements RowMapper<String>{
	@Override
	public String mapRow(ResultSet arg0, int arg1) throws SQLException {

		return null;
	}
}
