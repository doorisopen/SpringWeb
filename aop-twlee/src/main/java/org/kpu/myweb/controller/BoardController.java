package org.kpu.myweb.controller;

import org.kpu.myweb.utils.CommandMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
	
	/*
	 * Board Register 
	 * 
	 */
	@RequestMapping(value = "/BoardRegister", method = RequestMethod.POST)
	public String BoardRegister() throws Exception{

		System.out.println("BoardRegister Start");
		// event 
		
		// notice
		
		return "";
	}
	/*
	 * Board List 
	 * 
	 */
	@RequestMapping(value = "/BoardList", method = RequestMethod.POST)
	public String BoardList() throws Exception{

		System.out.println("BoardList Start");
		// event 
		
		// notice
		
		return "";
	}
	/*
	 * Board Detail 
	 * 
	 */
	@RequestMapping(value = "/BoardDetail", method = RequestMethod.POST)
	public String BoardDetail() throws Exception{

		System.out.println("BoardDetail Start");
		// event 
		
		// notice
		
		return "";
	}
	/*
	 * Board Update 
	 * 
	 */
	@RequestMapping(value = "/BoardUpdate", method = RequestMethod.POST)
	public String BoardUpdate() throws Exception{

		System.out.println("BoardUpdate Start");
		// event 
		
		// notice
		
		return "";
	}
	/*
	 * Board Delete 
	 * 
	 */
	@RequestMapping(value = "/BoardDelete", method = RequestMethod.POST)
	public String BoardDelete() throws Exception{

		System.out.println("BoardDelete Start");
		// event 
		
		// notice
		
		return "";
	}
	

}
