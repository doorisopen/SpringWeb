package org.kpu.myweb;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.myweb.domain.ReviewVO;
import org.kpu.myweb.persistence.ReviewDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class reviewTest {

	@Autowired
	private ReviewDAO dao;
	private static Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	
	/*
	 * 리뷰 JSON 형변환 테스트
	 */
	@Test
	public void reviewListTest() throws Exception {
    	JSONArray json = new JSONArray();
    	JSONObject responseObj = new JSONObject();
    	ReviewVO reviewVO = new ReviewVO();
    	
    	reviewVO.setStoreName("전주식당");
    	
        // 해당 게시물 댓글
        List<ReviewVO> reviewList = dao.StoreProfileReviewList(reviewVO);

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
        
        System.out.println("JSON List : " + json);
	}
	

}
