package org.kpu.myweb.persistence;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private static final String namespace ="org.kpu.myweb.UserMapper";
	
	/*
	 * 사용자 등록
	 * 
	 */
	public int UserRegister(UserVO vo) {
		
		return sqlSession.insert(namespace + ".UserRegister", vo);
	}
	/*
	 * 아이디 등록 조회
	 * 
	 */
	@SuppressWarnings("unchecked")
	public int UserCheck(Map<String, Object> map) throws Exception {
		Map<String, Object> resultMap = (Map<String, Object>)sqlSession.selectOne(namespace + ".UserCheck", map);
		int result = Integer.valueOf(String.valueOf(resultMap.get("RESULT")));
		
		return result;
	}
	

}
