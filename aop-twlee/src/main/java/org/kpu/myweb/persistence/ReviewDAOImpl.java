package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.domain.BoardVO;
import org.kpu.myweb.domain.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private static final String namespace ="org.kpu.myweb.ReviewMapper";

	@Override
	public int ReviewCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<ReviewVO> CeoStoreProfileReviewList(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub ReviewList
		List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		reviewList = sqlSession.selectList(namespace + ".CeoStoreProfileReviewList", vo);
		return reviewList;
	}
	@Override
	public List<ReviewVO> UserProfileReviewList(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub ReviewList
		List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		reviewList = sqlSession.selectList(namespace + ".UserProfileReviewList", vo);
		return reviewList;
	}
	@Override
	public List<ReviewVO> StoreProfileReviewList(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub ReviewList
		List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		reviewList = sqlSession.selectList(namespace + ".StoreProfileReviewList", vo);
		return reviewList;
	}

	@Override
	public int ReviewRegister(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".ReviewRegister", vo);
	}

	@Override
	public int ReviewUpdate(ReviewVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ReviewDelete(int reviewIdx) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	/*
	 * 리뷰 등록
	 * 
	 */
	
}
