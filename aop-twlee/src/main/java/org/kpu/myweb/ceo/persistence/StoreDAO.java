package org.kpu.myweb.ceo.persistence;

import java.util.List;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.domain.StudentVO;

public interface StoreDAO {
	
	public int StoreRegister(StoreVO vo) throws Exception;

}
