package jp.levelfive.framework;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// import org.springframework.validation.BindingResult;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private FormBean form;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	public FormBean getForm() {
		return form;
	}

	public void setForm(FormBean form) {
		this.form = form;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(FormBean form, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		form = new FormBean();

		model.addAttribute("message", "名前とメールアドレスを入力ください。");
		model.addAttribute("command", form);

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String form(@Valid FormBean form, BindingResult result,
			Locale locale, Model model) throws ServletException {
		logger.info("form: " + form.getName() + "," + form.getMail());
		String re = "";
		if (result.hasErrors()) {
			model.addAttribute("name_err", result.getFieldError("name"));
			model.addAttribute("mail_err", result.getFieldError("mail"));
			re = "再入力してください。";
			model.addAttribute("command", result.getTarget());
			return "home";
		} else {
			re = "name:" + form.getName() + "<br>mail:" + form.getMail();
			model.addAttribute("command", form);
		}
		model.addAttribute("message", re);
		return "home";
	}
}
