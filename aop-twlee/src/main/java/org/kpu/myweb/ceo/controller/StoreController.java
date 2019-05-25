package org.kpu.myweb.ceo.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.ceo.service.StoreService;
import org.kpu.myweb.controller.UserController;
import org.kpu.myweb.domain.BoardVO;
import org.kpu.myweb.domain.UserVO;
import org.kpu.myweb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class StoreController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	StoreService service;
	
	@Autowired
	UserService userservice;

	UserVO uservo = new UserVO();
	
	/* ***************************** *
	 * *                           * *
	 * *       Store GET           * *
	 * *                           * *
	 * ***************************** */

	/*
	 * Store Register Page 
	 * 
	 */
	@RequestMapping(value = "/StoreRegisterPage", method = RequestMethod.GET)
	public String StoreRegisterPage(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

		return "Ceo/C_store/storeRegister";
	}
	
	/*
	 * Store List 
	 * 
	 */
	@RequestMapping(value = "/StoreList", method = RequestMethod.GET)
	public String StoreList(Model model, HttpServletRequest request, @ModelAttribute StoreVO vo, HttpServletResponse response) throws Exception{
		
		System.out.println("StoreList Start");
		String storeCategory = request.getParameter("storeCategory");
		System.out.println("StoreList Category = " + storeCategory);
		
		
		List<StoreVO> storeList = service.StoreList(vo);
		model.addAttribute("storeList", storeList);
		
		return "User/storeList";
	}
	
	/*
	 * CEO -> Store Profile 
	 * 
	 */
	@RequestMapping(value = "/ceoStoreDetail", method = RequestMethod.GET)
    public String CeoStoreDetail(@RequestParam("storeName") String storeName, StoreVO vo, Model model) throws Exception {

		
    	vo = service.StoreDetail(storeName);
		logger.info(" /CeoStoreDetail URL called. then CeoStoreDetail method executed.");
		
        model.addAttribute("storeDetail", vo);
        
        return "Ceo/C_store/storeProfile";
    }
	
	/*
	 * User -> Store Profile 
	 * 
	 */
	@RequestMapping(value = "/StoreDetail", method = RequestMethod.GET)
    public String UserStoreDetail(@RequestParam("storeName") String storeName, StoreVO vo, Model model) throws Exception {
		
		System.out.println("storeName = " + storeName);
		
    	vo = service.StoreDetail(storeName);
		logger.info(" /UserStoreDetail URL called. then UserStoreDetail method executed.");
		
        model.addAttribute("storeDetail", vo);
        
        return "User/storeProfile";
    }
	
	
	/* ***************************** *
	 * *                           * *
	 * *       Store POST          * *
	 * *                           * *
	 * ***************************** */
	
	/*
	 * Store Register 
	 *
	 */
	@RequestMapping("/StoreRegister")
	public String StoreRegister(RedirectAttributes rttr, ModelMap modelMap, @ModelAttribute StoreVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		
	    	String writer = uservo.getSecurityUser();
	    	vo.setWriter(writer); 
			try {
				System.out.println("storeName : "+ request.getParameter("storeName"));
		    	System.out.println("storeAddress : "+ request.getParameter("storeAddress"));
		    	System.out.println("storeTel : "+ request.getParameter("storeTel"));
		    	System.out.println("storeCategory : "+ request.getParameter("storeCategory"));
		    	System.out.println("storeImg : "+ request.getParameter("storeImg"));
		    	System.out.println("wirter : "+ writer);
		    	
				service.StoreRegister(vo); 
				System.out.println("등록 성공");
				
				System.out.println("권한 설정");
				String authority = "ROLE_CEO";
				uservo.setUserId(writer); uservo.setAuthority(authority);
				userservice.UserAuthorityUpdate(uservo);
				
			}catch (Exception e) {
	            if (logger.isErrorEnabled()) {
	                logger.error(e.getMessage(), e);
	            }
	        }

		return "redirect:/";
	}
	
	
	
	/*
	 * 회원 프로필 수정
	 * 
	 */
    @RequestMapping(value = "/StoreUpdate", method = RequestMethod.POST)
    public String modifyMemberPost(HttpServletRequest request, StoreVO vo) throws Exception {
    	
    	System.out.println("storeName : "+ request.getParameter("storeName"));
    	System.out.println("storeAddress : "+ request.getParameter("storeAddress"));
    	System.out.println("storeTel : "+ request.getParameter("storeTel"));
    	
    	
    	
    	service.StoreUpdate(vo);
		logger.info(vo.toString());
		logger.info("/StoreUpdate URL method called. then StoreUpdate POST method executed.");
        return "redirect:/ceoStoreDetail";
    }
}
