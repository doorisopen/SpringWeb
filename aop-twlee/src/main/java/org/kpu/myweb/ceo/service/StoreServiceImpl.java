package org.kpu.myweb.ceo.service;

import org.kpu.myweb.ceo.persistence.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreDAO storeDAO;
	
	
}
