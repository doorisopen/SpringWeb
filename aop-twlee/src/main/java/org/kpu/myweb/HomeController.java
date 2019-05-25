package org.kpu.myweb;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.ceo.service.StoreService;
import org.kpu.myweb.domain.BoardVO;
import org.kpu.myweb.domain.UserVO;
import org.kpu.myweb.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	BoardService boardservice;
	
	@Autowired
	StoreService storeservice;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/*
		 	수정 예정..
		 */
		BoardVO vo = new BoardVO();
		vo.setBoardFlag("not");
		List<BoardVO> noticeList = boardservice.BoardList(vo);
		model.addAttribute("notice", noticeList);
		
		return "home";

	}
	
	@RequestMapping(value = "/ceo", method = RequestMethod.GET)
	public String ceohome(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		UserVO uservo = new UserVO();
		StoreVO storevo = new StoreVO();
		
		String writer = uservo.getSecurityUser();
		storevo.setWriter(writer);

		List<StoreVO> CeoStoreList = storeservice.CeoStoreList(storevo);
		model.addAttribute("ceoStoreList", CeoStoreList);
		
		return "/Ceo/ceoHome";

	}
	@RequestMapping(value="/access_denied_page")
    public String accessDeniedPage() throws Exception {
		
        return "/Common/exception/access_denied_page";
    }
}
