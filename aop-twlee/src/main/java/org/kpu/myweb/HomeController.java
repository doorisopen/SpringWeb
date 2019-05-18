package org.kpu.myweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/ceo", method = RequestMethod.GET)
	public String ceohome(Locale locale, Model model) {
		logger.info("Welcome ceoHome! The client locale is {}.", locale);
		
		
		return "Ceo/ceoHome";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome login! The client locale is {}.", locale);
		
		
		return "User/login";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		logger.info("Welcome register! The client locale is {}.", locale);
		
		
		return "User/register";
	}
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Locale locale, Model model) {
		logger.info("Welcome profile! The client locale is {}.", locale);
		
		
		return "User/profile";
	}
}
