package jp.levelfive.kaigishitsu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class YoyakuOptionDAO extends JdbcDaoSupport{
	@Autowired
	DataSource dataSource;

	public YoyakuOptionList getYoyakuOptions() throws DataAccessException{
		String sql;
		RowMapper<YoyakuOption> optionRowMapper = new YoyakuOptionRowMapper();
		YoyakuOptionList optionList =new YoyakuOptionList();

		sql = "select roomId, roomName from room";
		optionList.setRoomList(getJdbcTemplate().query(sql, optionRowMapper));

		sql = "select userId, userName from user";
		optionList.setUserList(getJdbcTemplate().query(sql, optionRowMapper));

		sql = "select usageId, mokuteki from mokuteki";
		optionList.setUsageList(getJdbcTemplate().query(sql, optionRowMapper));

		return optionList;
	}
}
class YoyakuOptionRowMapper implements RowMapper<YoyakuOption>{
	private List<YoyakuOption> optionList = new ArrayList<YoyakuOption>();

	public List<YoyakuOption> getResults(){
		return optionList;
	}

	@Override
	public YoyakuOption mapRow(ResultSet rs, int rowNum) throws SQLException {

		 return new YoyakuOption(rs.getInt(1),rs.getString(2));
	}
}
