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
	private YoyakuOptionDAO optionDAO;
	@Autowired
	private AccountDAO accountDAO;

	private AccountData accountData;
	private YoyakuData yoyakuData = new YoyakuData();
	private YoyakuOptionList optionList;
	private CalendarForm calendar = new CalendarForm();
	private TimeTable timeTable = new TimeTable();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//予約フォームの選択肢のセット
		//部屋　年　月　週　日　開始時刻　終了時刻　予約者　使用目的
		optionList = optionDAO.getYoyakuOptions();
		yoyakuData = new YoyakuData();
		model.addAttribute("roomList", optionList.getRoomList());
		model.addAttribute("yearList",optionList.getYearList());
		model.addAttribute("monthList",optionList.getMonthList());
		model.addAttribute("weekList",optionList.getWeekList());
		model.addAttribute("dayList",optionList.getDayList());
		model.addAttribute("hourList",optionList.getHourList());
		model.addAttribute("minuteList",optionList.getMinuteList());
		model.addAttribute("userList", optionList.getUserList());
		model.addAttribute("usageList", optionList.getUsageList());
		model.addAttribute("yoyaku", yoyakuData);

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

	@RequestMapping(value="/",method = RequestMethod.POST)
	public String yoyaku(YoyakuData yoyakuData, Model model,BindingResult result) throws ServletException {
		yoyakuData.setDate();
		yoyakuData.setStartTime();
		yoyakuData.setEndTime();
		int setResult = yoyakuDAO.setYoyaku(yoyakuData);

		if (setResult == 0) {
			model.addAttribute("message", "fail");
		} else if (setResult >= 1) {
			model.addAttribute("message", "success");
		}
		// 結果を受け取って、messageにセット → ダイアログを出力
		//予約フォームの選択肢のセット
		//部屋　年　月　週　日　開始時刻　終了時刻　予約者　使用目的
		optionList = optionDAO.getYoyakuOptions();
		model.addAttribute("roomList", optionList.getRoomList());
		model.addAttribute("yearList",optionList.getYearList());
		model.addAttribute("monthList",optionList.getMonthList());
		model.addAttribute("weekList",optionList.getWeekList());
		model.addAttribute("dayList",optionList.getDayList());
		model.addAttribute("hourList",optionList.getHourList());
		model.addAttribute("minuteList",optionList.getMinuteList());
		model.addAttribute("userList", optionList.getUserList());
		model.addAttribute("usageList", optionList.getUsageList());
		model.addAttribute("yoyaku", yoyakuData);
		model.addAttribute("yoyaku", result.getTarget());

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

	@RequestMapping(value="{index}",method=RequestMethod.GET)
	public String date(@PathVariable String index,Model model){
		//予約フォームの選択肢のセット
		//部屋　年　月　週　日　開始時刻　終了時刻　予約者　使用目的
		optionList = optionDAO.getYoyakuOptions();
		model.addAttribute("roomList", optionList.getRoomList());
		model.addAttribute("yearList",optionList.getYearList());
		model.addAttribute("monthList",optionList.getMonthList());
		model.addAttribute("weekList",optionList.getWeekList());
		model.addAttribute("dayList",optionList.getDayList());
		model.addAttribute("hourList",optionList.getHourList());
		model.addAttribute("minuteList",optionList.getMinuteList());
		model.addAttribute("userList", optionList.getUserList());
		model.addAttribute("usageList", optionList.getUsageList());
		model.addAttribute("yoyaku", yoyakuData);

		//カレンダーのセット
		int year = CalendarForm.getCurrentYear();
		int month = CalendarForm.getCurrentMonth();
		calendar.setCalendarMatrix(year, month);
		if(index!="　"){
			model.addAttribute("date", index);
		}else{
			model.addAttribute("date", CalendarForm.getToday());
		}
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
		//予約フォームの選択肢のセット
		//部屋　年　月　週　日　開始時刻　終了時刻　予約者　使用目的
		optionList = optionDAO.getYoyakuOptions();
		model.addAttribute("roomList", optionList.getRoomList());
		model.addAttribute("yearList",optionList.getYearList());
		model.addAttribute("monthList",optionList.getMonthList());
		model.addAttribute("weekList",optionList.getWeekList());
		model.addAttribute("dayList",optionList.getDayList());
		model.addAttribute("hourList",optionList.getHourList());
		model.addAttribute("minuteList",optionList.getMinuteList());
		model.addAttribute("userList", optionList.getUserList());
		model.addAttribute("usageList", optionList.getUsageList());
		model.addAttribute("yoyaku", yoyakuData);
		//12月の場合、年を一つ進めて、1月(month=0)にする
		calendar.setCalendarMatrix(year, month);
		model.addAttribute("date", CalendarForm.getToday());
		model.addAttribute("year", year);
		model.addAttribute("month", month+1);
		model.addAttribute("calendarMatrix",calendar.getCalendarMatrix());
		//TODO タイムテーブルのセット

		return "home";
	}

	@RequestMapping(value="/back", method = RequestMethod.GET)
	public String back(Model model){
		CalendarForm.setCurrentMonthBack();
		int year = CalendarForm.getCurrentYear();
		int month = CalendarForm.getCurrentMonth();
		//予約フォームの選択肢のセット
		//部屋　年　月　週　日　開始時刻　終了時刻　予約者　使用目的
		optionList = optionDAO.getYoyakuOptions();
		model.addAttribute("roomList", optionList.getRoomList());
		model.addAttribute("yearList",optionList.getYearList());
		model.addAttribute("monthList",optionList.getMonthList());
		model.addAttribute("weekList",optionList.getWeekList());
		model.addAttribute("dayList",optionList.getDayList());
		model.addAttribute("hourList",optionList.getHourList());
		model.addAttribute("minuteList",optionList.getMinuteList());
		model.addAttribute("userList", optionList.getUserList());
		model.addAttribute("usageList", optionList.getUsageList());
		model.addAttribute("yoyaku", yoyakuData);
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
