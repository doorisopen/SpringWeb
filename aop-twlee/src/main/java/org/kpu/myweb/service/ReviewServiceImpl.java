package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.domain.ReviewVO;
import org.kpu.myweb.persistence.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	public List<ReviewVO> CeoStoreProfileReviewList(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.CeoStoreProfileReviewList(vo);
	}
	@Override
	public List<ReviewVO> UserProfileReviewList(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.UserProfileReviewList(vo);
	}
	@Override
	public List<ReviewVO> StoreProfileReviewList(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.StoreProfileReviewList(vo);
	}

	@Override
	public int ReviewRegister(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.ReviewRegister(vo);
	}

	@Override
	public int ReviewUpdate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.ReviewUpdate(vo);
	}

	@Override
	public int ReviewDelete(int reviewIdx) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.ReviewDelete(reviewIdx);
	}


	
}
