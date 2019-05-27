package org.kpu.myweb.ceo.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.ceo.domain.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDAOImpl implements MenuDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private static final String namespace ="org.kpu.myweb.MenuMapper";

	@Override
	public List<MenuVO> CeoStoreMenuList(MenuVO vo) throws Exception {
		// TODO Auto-generated method stub ReviewList
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		menuList = sqlSession.selectList(namespace + ".CeoStoreMenuList", vo);
		return menuList;
	}
	@Override
	public List<MenuVO> StoreMenuList(MenuVO vo) throws Exception {
		// TODO Auto-generated method stub ReviewList
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		menuList = sqlSession.selectList(namespace + ".StoreMenuList", vo);
		return menuList;
	}

	@Override
	public int MenuRegister(MenuVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".MenuRegister", vo);
	}

	@Override
	public int MenuUpdate(MenuVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int MenuDelete(int reviewIdx) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getStoreName(int reviewIdx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".getStoreName", reviewIdx);
	}
	
	/*
	 * 리뷰 등록
	 * 
	 */
	
}
