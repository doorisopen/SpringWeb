package org.kpu.myweb.ceo.persistence;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.ceo.domain.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAOImpl implements StoreDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace ="org.kpu.myweb.StoreMapper";
	
	
	/*
	 * 가게 등록
	 * 
	 */
	public int StoreRegister(StoreVO vo) {
		
		return sqlSession.insert(namespace + ".StoreRegister", vo);
	}
}
