package jp.levelfive.kaigishitsu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private KaigishitsuDAO kaigishitsuDAO;
	private AccountBean accountForm;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	public void setAccountForm(AccountBean accountForm) {
		this.accountForm = accountForm;
	}

	public AccountBean getAccountForm() {
		return accountForm;
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model) {
		logger.info("account method");
		accountForm = new AccountBean();
		model.addAttribute("message", "名前と削除用のパスワードを入力してください");
		model.addAttribute("signIn", accountForm);
		return "account";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String signIn(@Valid AccountData accountForm, BindingResult result,
			Model model) throws ServletException {
		logger.info("sign in method");
		if (result.hasErrors()) {
			model.addAttribute("name_err", result.getFieldError("name"));
			model.addAttribute("password_err", result.getFieldError("password"));
			model.addAttribute("message", "再入力してください");
			model.addAttribute("signIn", result.getTarget());
		} else {
			model.addAttribute("message", "登録に成功しました。");
			System.out.println("signIn method class:" + accountForm.getClass());
			System.out.println("signIn method name:" + accountForm.getName());
			kaigishitsuDAO.setAccount(accountForm);
			model.addAttribute("signIn", result.getTarget());
		}
		return "account";

	}
}
