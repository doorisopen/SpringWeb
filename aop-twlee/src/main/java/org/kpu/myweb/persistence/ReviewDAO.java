package org.kpu.myweb.persistence;

import java.util.List;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.domain.ReviewVO;

public interface ReviewDAO {
	
	public int ReviewCount() throws Exception;
	public List<ReviewVO> CeoStoreProfileReviewList(ReviewVO vo) throws Exception;
	public List<ReviewVO> UserProfileReviewList(ReviewVO vo) throws Exception;
	public List<ReviewVO> StoreProfileReviewList(ReviewVO vo) throws Exception;
	public int ReviewRegister(ReviewVO vo) throws Exception;
	public int ReviewUpdate(ReviewVO vo) throws Exception;
	public int ReviewDelete(int reviewIdx) throws Exception;
	

}
