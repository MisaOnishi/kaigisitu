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
	private String sql = "";
	@Autowired
	DataSource dataSource;
	YoyakuOption options = new YoyakuOption();

	//TODO 選択肢の取得
	public YoyakuOptionList getYoyakuOptions() throws DataAccessException{
		RowMapper<YoyakuOption> optionRowMapper = new YoyakuOptionRowMapper();
		YoyakuOptionList optionList = YoyakuOptionList.getInstance();

		sql = "select (id, room) from room";
		optionList.setRooms(getJdbcTemplate().query(sql, optionRowMapper));

		sql = "select (id, user) from user";
		optionList.setUsers(getJdbcTemplate().query(sql, optionRowMapper));

		sql = "select (id, usage) from usage";
		optionList.setUsers(getJdbcTemplate().query(sql, optionRowMapper));

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
		YoyakuOption option = new YoyakuOption();
		option.setId(rs.getInt(1));
		option.setName(rs.getString(2));
		return null;
	}
}
