package org.kpu.myweb.ceo.persistence;

import java.util.List;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.domain.ReviewVO;
import org.kpu.myweb.domain.StudentVO;

public interface StoreDAO {
	
	public int StoreRegister(StoreVO vo) throws Exception;
	public List<StoreVO> StoreList(StoreVO vo) throws Exception;
	public List<StoreVO> CeoStoreList(StoreVO vo) throws Exception;
	public StoreVO StoreDetail(String storeName) throws Exception;
	public void StoreUpdate(StoreVO vo) throws Exception;
	public void StoreDelete(String id) throws Exception;
	public void updateReplyCnt(String storeName, int i);
	List<StoreVO> listPaging(int page) throws Exception;
}
