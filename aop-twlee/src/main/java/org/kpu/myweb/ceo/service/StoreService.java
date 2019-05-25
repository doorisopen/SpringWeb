package org.kpu.myweb.ceo.service;

import java.util.List;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.domain.BoardVO;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.domain.UserVO;

public interface StoreService {

	public void StoreRegister(StoreVO vo) throws Exception;
	public StoreVO StoreDetail(String storeName) throws Exception;
	public void StoreUpdate(StoreVO vo) throws Exception;
	public void StoreDelete(String storeName) throws Exception;
	public List<StoreVO> StoreList(StoreVO vo) throws Exception;
	public List<StoreVO> CeoStoreList(StoreVO vo) throws Exception;
	
	
}
