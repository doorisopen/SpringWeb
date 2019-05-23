package org.kpu.myweb.ceo.service;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.ceo.persistence.StoreDAO;
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
	public StoreVO StoreDetail(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void StoreUpdate(StoreVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void StoreDelete(String id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
