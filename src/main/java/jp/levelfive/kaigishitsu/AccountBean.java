package jp.levelfive.kaigishitsu;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class AccountBean {
	@Size(min = 1, max = 20)
	private String name;
	@Email
	private String mail;
	@Pattern(regexp = "^[0-9]{4}$")
	private String password;
	private String message;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
