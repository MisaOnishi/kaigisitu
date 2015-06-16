package jp.levelfive.framework;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

// import java.x.validation.constrains.Size;
// import org.hibernate.validator.constrains.Email;

public class FormBean {
	@Size(min = 3, max = 10)
	private String name = "your name.";
	@Email
	private String mail = "your@mail.";
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9]{8,32}$")
	private String password = "yourpassword";

	/**
	 * nameを取得します。
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameを設定します。
	 * 
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * mailを取得します。
	 * 
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * mailを設定します。
	 * 
	 * @param mail
	 *            mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * passwordを取得します。
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * passwordを設定します。
	 * 
	 * @param password
	 *            password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
