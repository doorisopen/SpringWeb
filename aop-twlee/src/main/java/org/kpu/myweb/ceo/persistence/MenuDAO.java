package org.kpu.myweb.ceo.persistence;

import java.util.List;

import org.kpu.myweb.ceo.domain.MenuVO;

public interface MenuDAO {
	
	public List<MenuVO> CeoStoreMenuList(MenuVO vo) throws Exception;
	public List<MenuVO> StoreMenuList(MenuVO vo) throws Exception;
	public int MenuRegister(MenuVO vo) throws Exception;
	public int MenuUpdate(MenuVO vo) throws Exception;
	public int MenuDelete(int reviewIdx) throws Exception;
	String getStoreName(int reviewIdx) throws Exception;
	

}
