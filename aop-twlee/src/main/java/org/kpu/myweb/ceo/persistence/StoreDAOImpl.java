package org.kpu.myweb.ceo.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/*
	 * 가게 리스트
	 * 
	 */
	@Override
	public List<StoreVO> StoreList(StoreVO vo) throws Exception {
		List<StoreVO> StoreList = new ArrayList<StoreVO>();
		StoreList = sqlSession.selectList(namespace + ".StoreList", vo);
		return StoreList;
	}
	
	/*
	 * ceo 등록 가게 리스트
	 * 
	 */
	@Override
	public List<StoreVO> CeoStoreList(StoreVO vo) throws Exception {
		List<StoreVO> CeoStoreList = new ArrayList<StoreVO>();
		CeoStoreList = sqlSession.selectList(namespace + ".CeoStoreList", vo);
		return CeoStoreList;
	}
	
	/*
	 * 가게 상세 프로필
	 * 
	 */
	@Override
	public StoreVO StoreDetail(String storeName) throws Exception {
		StoreVO vo = sqlSession.selectOne(namespace+".StoreDetail", storeName);
		return vo;
	}

	/*
	 * 가게 프로필 수정
	 * 
	 */
	@Override
	public void StoreUpdate(StoreVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".StoreUpdate", vo);
	}

	/*
	 * 가게 삭제
	 * 
	 */
	@Override
	public void StoreDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".StoreDelete", id);
	}
	
	@Override
    public List<StoreVO> listPaging(int page) throws Exception {

        if (page <= 0) {
            page = 1;
        }

        page = (page - 1) * 10;

        return sqlSession.selectList(namespace + ".listPaging", page);
    }
	
	@Override
	public void updateReplyCnt(int storeIdx, int amount) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("articleNo", storeIdx);
        paramMap.put("amount", amount);

        sqlSession.update(namespace + ".updateReplyCnt", paramMap);
	}
}
