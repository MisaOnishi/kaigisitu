package jp.levelfive.kaigishitsu;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class YoyakuOptionDAO extends JdbcDaoSupport{
	private String sql = "";
	private static final Logger logger = LoggerFactory.getLogger(KaigishitsuDAO.class);
	@Autowired
	DataSource dataSource;

	//TODO 選択肢の取得
	public YoyakuOption getYoyakuOptions() throws DataAccessException{
		RowMapper<YoyakuOption> yoyakuOptionRowMapper = new YoyakuOptionRowMapper();
		sql = "select (id, name) from reservation where date";
		getJdbcTemplate().query(sql, yoyakuOptionRowMapper);
		return null;
	}

}
class YoyakuOptionRowMapper implements RowMapper<YoyakuOption>{

	@Override
	public YoyakuOption mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
