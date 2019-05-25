package org.kpu.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.kpu.myweb.ceo.persistence.StoreDAO;
import org.kpu.myweb.domain.ReviewVO;
import org.kpu.myweb.persistence.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDAO reviewDAO;
	private final StoreDAO storeDAO;
	
	@Inject
	public ReviewServiceImpl(ReviewDAO reviewDAO, StoreDAO storeDAO) {
		this.reviewDAO = reviewDAO;
		this.storeDAO = storeDAO;
	}
	
	
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
	
	@Transactional
	@Override
	public void ReviewRegister(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		reviewDAO.ReviewRegister(vo);
		storeDAO.updateReplyCnt(vo.getStoreName(), 1); // 댓글 갯수 증가
		
	}

	@Override
	public int ReviewUpdate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.ReviewUpdate(vo);
	}
	
	@Transactional
	@Override
	public void ReviewDelete(int reviewIdx) throws Exception {
		// TODO Auto-generated method stub
		String storeName = reviewDAO.getStoreName(reviewIdx);
		reviewDAO.ReviewDelete(reviewIdx);
		storeDAO.updateReplyCnt(storeName, -1); // 댓글 갯수 감소
	}
	

	
}
