package org.kpu.myweb.ceo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.ceo.service.StoreService;
import org.kpu.myweb.controller.UserController;
import org.kpu.myweb.domain.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class StoreController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	StoreService service;
	
	UserVO uservo = new UserVO();
	
	/* ***************************** *
	 * *                           * *
	 * *       Store GET           * *
	 * *                           * *
	 * ***************************** */
	@RequestMapping(value = "/StoreList", method = RequestMethod.GET)
	public String StoreList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

		return "User/storeList";
	}
	@RequestMapping(value = "/StoreProfile", method = RequestMethod.GET)
	public String StoreProfile(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

		return "Ceo/C_store/storeProfile";
	}
	@RequestMapping(value = "/StoreRegisterPage", method = RequestMethod.GET)
	public String StoreRegister(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{

		return "Ceo/C_store/storeRegister";
	}
	
	/* ***************************** *
	 * *                           * *
	 * *       Store POST          * *
	 * *                           * *
	 * ***************************** */
	@RequestMapping("/StoreRegister")
	public String StoreRegister(RedirectAttributes rttr, ModelMap modelMap, @ModelAttribute StoreVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		
	    	String writer = uservo.getSecurityUser();
	    	vo.setWriter(writer);
			try {
				//service.StoreRegister(vo); 
				System.out.println("storeName : "+ request.getParameter("storeName"));
		    	System.out.println("storeAddress : "+ request.getParameter("storeAddress"));
		    	System.out.println("storeTel : "+ request.getParameter("storeTel"));
		    	System.out.println("Category : "+ request.getParameter("category"));
		    	System.out.println("storeImg : "+ request.getParameter("storeImg"));
		    	System.out.println("wirter : "+ writer);
		    	
				System.out.println("등록 성공");
				
			}catch (Exception e) {
	            if (logger.isErrorEnabled()) {
	                logger.error(e.getMessage(), e);
	            }
	        }

		return "redirect:/";
	}
}
