package org.kpu.myweb.ceo.service;

import java.util.List;

import org.kpu.myweb.ceo.domain.MenuVO;


public interface MenuService {

	public List<MenuVO> CeoStoreMenuList(MenuVO vo) throws Exception;
	public List<MenuVO> StoreMenuList(MenuVO vo) throws Exception;
	public void MenuRegister(MenuVO vo) throws Exception;
	public int ReviewUpdate(MenuVO vo) throws Exception;
	public void ReviewDelete(int menuIdx) throws Exception;
	
	
}
