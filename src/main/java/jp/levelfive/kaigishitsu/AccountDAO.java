package jp.levelfive.kaigishitsu;

import java.sql.ResultSet;
import java.sql.SQLException;
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

public class AccountDAO extends JdbcDaoSupport{
	private String sql = "";
	private static final Logger logger = LoggerFactory.getLogger(KaigishitsuDAO.class);
	@Autowired
	DataSource dataSource;

	//アカウントを登録
	public int setAccount(AccountData accountData) {
		JdbcTemplate setAccount = new JdbcTemplate(dataSource);
		sql = "insert into user(name, email, password) values('"
				+ accountData.getName() + "','" + accountData.getEmail()
				+ "','" + accountData.getPassword() + "')";
		logger.info(sql);
		return setAccount.update(sql);
	}

	//アカウントリストを取得
	public List<AccountData> getAccountList() throws DataAccessException {
		RowMapper<AccountData> accountRowMapper = new AccountRowMapper();
		sql = "select * from user";
		List<AccountData> accountList = getJdbcTemplate().query(sql,accountRowMapper);
		return accountList;
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
		accountData.setEmail(rs.getString("email"));
		accountData.setPassword(rs.getString("password"));
		return accountData;
	}
}

