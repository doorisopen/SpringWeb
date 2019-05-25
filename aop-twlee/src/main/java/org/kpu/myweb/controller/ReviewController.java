package org.kpu.myweb.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.domain.ReviewVO;
import org.kpu.myweb.domain.UserVO;
import org.kpu.myweb.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	ReviewService service;
	
    
	/**
     * 댓글 등록(Ajax)
     * @param storeIdx
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/ReviewRegister")
    @ResponseBody
    public String ReviewRegister(ReviewVO reviewVO, @RequestParam("storeName") String storeName, HttpServletRequest request) throws Exception{
    	
    	System.out.println("댓글등록 : " + storeName);
    	
    	UserVO uservo = new UserVO();
    	String writer = uservo.getSecurityUser();
    	reviewVO.setStoreName(storeName);
    	reviewVO.setWriter(writer); 
    	System.out.println("댓글 등록 성공 : " + writer);
        try{
        	       
        	service.ReviewRegister(reviewVO);
        	
        } catch (Exception e){
            e.printStackTrace();
            
        }
        
        return "success";
    }
    
    /**
     * 게시물 댓글 불러오기(Ajax) - Store Profile 리뷰 전체 출력 (수정 x, 삭제 x)
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/StoreProfileReviewList", produces="application/json; charset=utf8")
    @ResponseBody
    public JSONArray StoreProfileReviewList(ReviewVO reviewVO, @RequestParam("storeName") String storeName, HttpServletRequest request) throws Exception{
    	
    	System.out.println("storeName : " + storeName);
    	JSONArray json = new JSONArray();
    	JSONObject responseObj = new JSONObject();
        
        // 해당 게시물 댓글
        List<ReviewVO> reviewList = service.StoreProfileReviewList(reviewVO);

        try {
        	
        	if(reviewList.size() > 0){
                for(int i=0; i<reviewList.size(); i++){
                    HashMap hm = new HashMap();
                    int reviewIdx = reviewList.get(i).getReviewIdx();
                    String reviewContent = reviewList.get(i).getReviewContent();
                    String writer = reviewList.get(i).getWriter();
                    String writeDate = reviewList.get(i).getWriteDate();
                                
	                JSONObject obj = new JSONObject();
	                obj.put("reviewIdx", reviewIdx);
	                obj.put("reviewContent", reviewContent);
	                obj.put("writer", writer);
	                obj.put("writeDate", writeDate);
                
	                json.add(obj);
                }
            }
            	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        return json;
    }
    
    /**
     * 게시물 댓글 불러오기(Ajax) - User Profile 사용자 작성 리뷰만 출력 (수정 o, 삭제 o)
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/UserProfileReviewList", produces="application/json; charset=utf8")
    @ResponseBody
    public JSONArray UserProfileReviewList(ReviewVO reviewVO, @RequestParam("userId") String userId, HttpServletRequest request) throws Exception{
    	
    	JSONArray json = new JSONArray();
    	JSONObject responseObj = new JSONObject();
    	reviewVO.setWriter(userId);
        // 해당 게시물 댓글
        List<ReviewVO> reviewList = service.UserProfileReviewList(reviewVO);

        try {
        	
        	if(reviewList.size() > 0){
                for(int i=0; i<reviewList.size(); i++){
                    HashMap hm = new HashMap();
                    int reviewIdx = reviewList.get(i).getReviewIdx();
                    String reviewContent = reviewList.get(i).getReviewContent();
                    String storeName = reviewList.get(i).getStoreName();
                    String writer = reviewList.get(i).getWriter();
                    String writeDate = reviewList.get(i).getWriteDate();
                                
	                JSONObject obj = new JSONObject();
	                obj.put("reviewIdx", reviewIdx);
	                obj.put("reviewContent", reviewContent);
	                obj.put("storeName", storeName);
	                obj.put("writer", writer);
	                obj.put("writeDate", writeDate);
                
	                json.add(obj);
                }
            }
            	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        return json;
    }
    
    /**
     * 게시물 댓글 불러오기(Ajax) - Ceo Store Profile 리뷰 전체 출력 (수정 x, 삭제 o)
     * @param request
     * @return 
     * @throws Exception
     */
    @RequestMapping(value="/CeoStoreProfileReviewList", produces="application/json; charset=utf8")
    @ResponseBody
    public JSONArray CeoStoreProfileReviewList(ReviewVO reviewVO, @RequestParam("storeName") String storeName, HttpServletRequest request) throws Exception{
    	
    	System.out.println("storeName : " + storeName);
    	JSONArray json = new JSONArray();
    	JSONObject responseObj = new JSONObject();
        
        // 해당 게시물 댓글
        List<ReviewVO> reviewList = service.CeoStoreProfileReviewList(reviewVO);

        try {
        	
        	if(reviewList.size() > 0){
                for(int i=0; i<reviewList.size(); i++){
                    HashMap hm = new HashMap();
                    int reviewIdx = reviewList.get(i).getReviewIdx();
                    String reviewContent = reviewList.get(i).getReviewContent();
                    String writer = reviewList.get(i).getWriter();
                    String writeDate = reviewList.get(i).getWriteDate();
                                
	                JSONObject obj = new JSONObject();
	                obj.put("reviewIdx", reviewIdx);
	                obj.put("reviewContent", reviewContent);
	                obj.put("writer", writer);
	                obj.put("writeDate", writeDate);
                
	                json.add(obj);
                }
            }
            	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        return json;
    }
    
    
    @RequestMapping("/ReviewUpdate") //댓글 수정  
    @ResponseBody
    private int ReviewUpdate(@RequestParam int reviewIdx, @RequestParam String reviewContent) throws Exception{
        
    	ReviewVO vo = new ReviewVO();
    	vo.setReviewIdx(reviewIdx);
    	vo.setReviewContent(reviewContent);
        
        return service.ReviewUpdate(vo);
    }
    
    @RequestMapping("/ReviewDelete/{reviewIdx}") //댓글 삭제  
    @ResponseBody
    private void ReviewDelete(@PathVariable int reviewIdx) throws Exception{
        
        service.ReviewDelete(reviewIdx);
    }

	
   
}
