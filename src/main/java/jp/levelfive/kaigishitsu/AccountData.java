package jp.levelfive.kaigishitsu;

public class AccountData {
	private int id;
	private String name;
	private String password;

	public AccountData() {
		super();
	}

	public AccountData(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		System.out.println("get" + this.name);
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
