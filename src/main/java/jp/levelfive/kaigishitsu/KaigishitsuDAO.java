package jp.levelfive.kaigishitsu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class KaigishitsuDAO extends JdbcDaoSupport {
	private String sql = "";

	private JdbcTemplate jdbcTemplate;

	public void setAccount(AccountData accountData) {
		sql = "insert into user(name, password) values("
				+ accountData.getName() + "," + accountData.getPassword() + ")";
		System.out.println(sql);
		new JdbcTemplate().execute(sql);

	}

	public List<AccountData> getAccountList() throws DataAccessException {
		RowMapper<AccountData> accountRowMapper = new AccountRowMapper();
		List<AccountData> accountList = getJdbcTemplate().query(sql,
				accountRowMapper);
		return accountList;
	}

	public List<YoyakuData> getYoyakuList() throws DataAccessException {
		return null;

	}

}

class AccountRowMapper implements RowMapper<AccountData> {
	private List<AccountData> accountList = new ArrayList<AccountData>();

	public List<AccountData> getResults() {
		return accountList;
	}

	@Override
	public AccountData mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccountData accountData = new AccountData();
		accountData.setId(rs.getInt("id"));
		accountData.setName(rs.getString("name"));
		accountData.setPassword(rs.getString("password"));
		return accountData;
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
