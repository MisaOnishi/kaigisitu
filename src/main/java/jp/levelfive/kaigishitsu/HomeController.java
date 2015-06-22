package jp.levelfive.kaigishitsu;

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

@Controller
public class HomeController {
	@Autowired
	private KaigishitsuDAO kaigishitsuDAO;
	private AccountData accountData;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		CalendarForm calendar = new CalendarForm();
		//
		model.addAttribute("year", calendar.getYear());
		model.addAttribute("month", calendar.getMonth() + 1);
		model.addAttribute("calenderMatrix", calendar.getCalendarMatrix());
		return "home";
	}

	/*
	 * public void setAccountForm(AccountData accountForm) {
	 * logger.info("setAccountForm method is called"); this.accountData =
	 * accountForm; }
	 * 
	 * public AccountData getAccountForm() {
	 * logger.info("getAccountForm method is called"); return accountData; }
	 */
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model) {
		logger.info("account method");
		accountData = new AccountData();
		model.addAttribute("message", "");
		model.addAttribute("signIn", accountData);
		return "account";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String signIn(@Valid AccountData accountData, BindingResult result,
			Model model) throws ServletException {
		logger.info("signIn method");
		if (result.hasErrors()) {// 不正な入力の場合
			model.addAllAttributes(result.getAllErrors());
			model.addAttribute("name_err", result.getFieldError("name"));
			model.addAttribute("email_err", result.getFieldError("email"));
			model.addAttribute("password_err", result.getFieldError("password"));
			model.addAttribute("message", "再入力してください");
			model.addAttribute("signIn", result.getTarget());
		} else {// 適正な入力の場合
			System.out.println("signIn method class:" + accountData.getClass());
			System.out.println("signIn method name:" + accountData.getName());
			int setResult = kaigishitsuDAO.setAccount(accountData);// データベースに登録
			if (setResult == 0) {
				model.addAttribute("message", "fail");
			} else if (setResult == 1) {
				model.addAttribute("message", "success");
			}
			// 結果を受け取って、messageにセット → ダイアログを出力
			model.addAttribute("signIn", result.getTarget());
		}
		return "account";
	}
}
