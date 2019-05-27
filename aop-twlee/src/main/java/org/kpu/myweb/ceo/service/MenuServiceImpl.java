package org.kpu.myweb.ceo.service;

import java.util.List;

import javax.inject.Inject;

import org.kpu.myweb.ceo.domain.MenuVO;
import org.kpu.myweb.ceo.persistence.MenuDAO;
import org.kpu.myweb.ceo.persistence.StoreDAO;
import org.kpu.myweb.domain.ReviewVO;
import org.kpu.myweb.persistence.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Override
	public List<MenuVO> CeoStoreMenuList(MenuVO vo) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.CeoStoreMenuList(vo);
	}
	@Override
	public List<MenuVO> StoreMenuList(MenuVO vo) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.StoreMenuList(vo);
	}
	
	@Transactional
	@Override
	public void MenuRegister(MenuVO vo) throws Exception {
		// TODO Auto-generated method stub
		menuDAO.MenuRegister(vo);
		
	}

	@Override
	public int ReviewUpdate(MenuVO vo) throws Exception {
		// TODO Auto-generated method stub
		return menuDAO.MenuUpdate(vo);
	}
	
	@Transactional
	@Override
	public void ReviewDelete(int menuIdx) throws Exception {
		// TODO Auto-generated method stub
		menuDAO.MenuDelete(menuIdx);
	}
	

	
}
