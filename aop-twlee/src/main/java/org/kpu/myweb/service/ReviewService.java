package org.kpu.myweb.service;

import java.util.List;
import java.util.Map;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.domain.ReviewVO;


public interface ReviewService {

	public List<ReviewVO> CeoStoreProfileReviewList(ReviewVO vo) throws Exception;
	public List<ReviewVO> UserProfileReviewList(ReviewVO vo) throws Exception;
	public List<ReviewVO> StoreProfileReviewList(ReviewVO vo) throws Exception;
	public void ReviewRegister(ReviewVO vo) throws Exception;
	public int ReviewUpdate(ReviewVO vo) throws Exception;
	public void ReviewDelete(int reviewIdx) throws Exception;
	
	
}
