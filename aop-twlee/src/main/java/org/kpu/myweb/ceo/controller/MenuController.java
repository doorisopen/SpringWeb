package org.kpu.myweb.ceo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.kpu.myweb.ceo.domain.MenuVO;
import org.kpu.myweb.ceo.service.MenuService;
import org.kpu.myweb.domain.ReviewVO;
import org.kpu.myweb.domain.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MenuController {

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	MenuService service;
	
    
	/**
     * 메뉴 등록(Ajax)
     * @param storeName
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/MenuRegister", method = RequestMethod.GET)
    @ResponseBody
    public String MenuRegister(MenuVO menuVO, @RequestParam("storeName") String storeName, HttpServletRequest request) throws Exception{
    	
    	System.out.println("메뉴등록 : " + storeName);
    	
    	UserVO uservo = new UserVO();
    	String writer = uservo.getSecurityUser();
    	menuVO.setStoreName(storeName);

    	System.out.println("메뉴 등록 성공 : " + writer);
        try{
        	       
        	service.MenuRegister(menuVO);
        	
        } catch (Exception e){
            e.printStackTrace();
            
        }
        
        return "success";
    }
    
    /**
     * 가게 메뉴 리스트 불러오기(Ajax) - Store Profile 메뉴 전체 출력 (수정 x, 삭제 x)
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/StoreMenuList", method = RequestMethod.GET, produces="application/json; charset=utf8")
    @ResponseBody
    public JSONArray StoreMenuList(MenuVO menuVO, @RequestParam("storeName") String storeName, HttpServletRequest request) throws Exception{
    	
    	System.out.println("storeName : " + storeName);
    	JSONArray json = new JSONArray();
        
        // 해당 게시물 댓글
        List<MenuVO> menuList = service.StoreMenuList(menuVO);

        try {
        	
        	if(menuList.size() > 0){
                for(int i=0; i<menuList.size(); i++){
                    int menuIdx = menuList.get(i).getMeunIdx();
                    String menuName = menuList.get(i).getMenuName();
                    String menuPrice = menuList.get(i).getMenuPrice();
                                
	                JSONObject obj = new JSONObject();
	                obj.put("menuIdx", menuIdx);
	                obj.put("menuName", menuName);
	                obj.put("menuPrice", menuPrice);
                
	                json.add(obj);
                }
            }
            	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        return json;
    }

    /**
     * 사장님 페이지 가게 메뉴 리스트 불러오기(Ajax) - Ceo Store Profile 리뷰 전체 출력 (수정 ㅇ, 삭제 o)
     * @param request
     * @return 
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/CeoStoreMenuList", method = RequestMethod.GET, produces="application/json; charset=utf8")
    @ResponseBody
    public JSONArray CeoStoreMenuList(MenuVO menuVO, @RequestParam("storeName") String storeName, HttpServletRequest request) throws Exception{
    	
    	System.out.println("storeName : " + storeName);
    	JSONArray json = new JSONArray();

        // 해당 게시물 댓글
        List<MenuVO> menuList = service.StoreMenuList(menuVO);

        try {
        	
        	if(menuList.size() > 0){
                for(int i=0; i<menuList.size(); i++){
                    int menuIdx = menuList.get(i).getMeunIdx();
                    String menuName = menuList.get(i).getMenuName();
                    String menuPrice = menuList.get(i).getMenuPrice();
                                
	                JSONObject obj = new JSONObject();
	                obj.put("menuIdx", menuIdx);
	                obj.put("menuName", menuName);
	                obj.put("menuPrice", menuPrice);
                
	                json.add(obj);
                }
            }
            	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        return json;
    }
    
    // 미구현
    
    @RequestMapping("/MenuUpdate") // 메뉴 수정  
    @ResponseBody
    private int MenuUpdate() throws Exception{
        
    	return 0;
    }
    
    @RequestMapping("/MenuDelete/{menuIdx}") // 메뉴 삭제  
    @ResponseBody
    private void MenuDelete(@PathVariable int menuIdx) throws Exception{
        
    }

	
   
}
