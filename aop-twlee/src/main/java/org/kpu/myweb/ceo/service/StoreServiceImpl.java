package org.kpu.myweb.ceo.service;

import java.util.List;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.ceo.persistence.StoreDAO;
import org.kpu.myweb.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreDAO storeDAO;

	@Override
	public void StoreRegister(StoreVO vo) throws Exception {
		// TODO Auto-generated method stub 
		storeDAO.StoreRegister(vo);
	}
	
	@Override
	public List<StoreVO> StoreList(StoreVO vo) throws Exception {
		// TODO Auto-generated method stub
		return storeDAO.StoreList(vo);
	}
	
	@Override
	public List<StoreVO> CeoStoreList(StoreVO vo) throws Exception {
		// TODO Auto-generated method stub
		return storeDAO.CeoStoreList(vo);
	}
	
	@Override
	public StoreVO StoreDetail(String storeName) throws Exception {
		// TODO Auto-generated method stub
		return storeDAO.StoreDetail(storeName);
	}

	@Override
	public void StoreUpdate(StoreVO vo) throws Exception {
		// TODO Auto-generated method stub
		storeDAO.StoreUpdate(vo);
	}

	@Override
	public void StoreDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		storeDAO.StoreDelete(id);
	}

	
	
	
}
