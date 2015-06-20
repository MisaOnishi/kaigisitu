package jp.levelfive.kaigishitsu;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class AccountData {
	private int id;
	//全角1文字以上20文字以下
	@Size(min = 1, max = 20)
	private String name;
	@Email
	private String email;
	//半角数字4文字
	@Pattern(regexp = "^[0-9]{4}$")
	private String password;

	public AccountData() {
		super();
	}

	public AccountData(String name,String email, String password) {
		super();
		this.name = name;
		this.email=email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

}
