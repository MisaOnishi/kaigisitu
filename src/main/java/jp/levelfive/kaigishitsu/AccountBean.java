package jp.levelfive.kaigishitsu;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccountBean {
	@Size(min = 3, max = 10)
	private String name;
	@Pattern(regexp = "^[a-zA-Z0-9]{8,32}$")
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
