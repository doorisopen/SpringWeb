package org.kpu.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kpu.myweb.domain.BoardVO;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	
	/*
	 * Board Register 
	 * 
	 */
	@RequestMapping(value = "/BoardRegister", method = RequestMethod.POST)
	public String BoardRegister(ModelMap modelMap, @ModelAttribute BoardVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
	    System.out.println("BoardRegister Start");
	    
	    String boardFlag = request.getParameter("boardFlag");
	    vo.setBoardFlag(boardFlag);
	    service.BoardRegister(vo);
		
		// event 
		
		// notice
		
		return "";
	}
	
	/*
	 * Board List 
	 * 
	 */
	@RequestMapping(value = "/BoardList", method = RequestMethod.GET)
	public String BoardList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		BoardVO vo = new BoardVO();
		System.out.println("BoardList Start");
		String boardFlag = request.getParameter("boardFlag");
		
		if(boardFlag.equals("not")) {
			// Notice
			vo.setBoardFlag(boardFlag);
			
		}else if(boardFlag.equals("eve")){
			// Event
			vo.setBoardFlag(boardFlag);
		}
		
		List<BoardVO> boardList = service.BoardList(vo);
		model.addAttribute("boardList", boardList);
		
		return "User/boardList";
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
