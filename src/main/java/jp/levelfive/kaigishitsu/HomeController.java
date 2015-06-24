package jp.levelfive.kaigishitsu;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired
	private YoyakuDAO yoyakuDAO;
	@Autowired
	private AccountDAO accountDAO;
	private AccountData accountData;
	private CalendarForm calendar = new CalendarForm();
	private TimeTable timeTable = new TimeTable();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//TODO 予約フォームのセット

		//カレンダーのセット
		CalendarForm calendar = new CalendarForm();
		model.addAttribute("year", calendar.getYear());
		model.addAttribute("month", calendar.getMonth() + 1);
		model.addAttribute("calendarMatrix", calendar.getCalendarMatrix());

		//TODO タイムテーブルのセット
		model.addAttribute("date", CalendarForm.getToday());
		model.addAttribute("timeTableArray", timeTable.getTimeTableArray());
		return "home";
	}

	@RequestMapping(value="/",method=RequestMethod.POST)
	public String home(YoyakuData yoyakuData, Model model){

		return "home";
	}

	@RequestMapping(value="{index}",method=RequestMethod.GET)
	public String date(@PathVariable String index,Model model){
		System.out.println("CALL date method");
		int year = CalendarForm.getCurrentYear();
		int month = CalendarForm.getCurrentMonth();
		calendar.setCalendarMatrix(year, month);
		model.addAttribute("date", index);
		model.addAttribute("year", year);
		model.addAttribute("month", month + 1);
		model.addAttribute("calendarMatrix", calendar.getCalendarMatrix());
		//TODO TimeTableクラスからタイムテーブルを取得してAttributeにセット

		return "home";
	}

	@RequestMapping(value="/forward", method = RequestMethod.GET)
	public String forward(Model model){
		CalendarForm.setCurrentMonthForward();
		int year = CalendarForm.getCurrentYear();
		int month = CalendarForm.getCurrentMonth();
		//12月の場合、年を一つ進めて、1月(month=0)にする
		calendar.setCalendarMatrix(year, month);
		model.addAttribute("date", CalendarForm.getToday());
		model.addAttribute("year", year);
		model.addAttribute("month", month+1);
		model.addAttribute("calendarMatrix",calendar.getCalendarMatrix());
		return "home";
	}

	@RequestMapping(value="/back", method = RequestMethod.GET)
	public String back(Model model){
		CalendarForm.setCurrentMonthBack();
		int year = CalendarForm.getCurrentYear();
		int month = CalendarForm.getCurrentMonth();
		//1月の場合、年を一つ戻して、12月(month=11)にする
		calendar.setCalendarMatrix(year, month);
		model.addAttribute("date", CalendarForm.getToday());
		model.addAttribute("year", year);
		model.addAttribute("month", month+1);
		model.addAttribute("calendarMatrix",calendar.getCalendarMatrix());
		return "home";
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model) {
		accountData = new AccountData();
		model.addAttribute("message", "");
		model.addAttribute("signIn", accountData);
		return "account";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String signIn(@Valid AccountData accountData, BindingResult result,
			Model model) throws ServletException {
		if (result.hasErrors()) {// 不正な入力の場合
			model.addAllAttributes(result.getAllErrors());
			model.addAttribute("name_err", result.getFieldError("name"));
			model.addAttribute("email_err", result.getFieldError("email"));
			model.addAttribute("password_err", result.getFieldError("password"));
			model.addAttribute("message", "再入力してください");
			model.addAttribute("signIn", result.getTarget());
		} else {// 適正な入力の場合
			int setResult = accountDAO.setAccount(accountData);// データベースに登録
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
