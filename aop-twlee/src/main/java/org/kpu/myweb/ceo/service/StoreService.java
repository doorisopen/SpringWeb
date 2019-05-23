package org.kpu.myweb.ceo.service;

import java.util.List;

import org.kpu.myweb.ceo.domain.StoreVO;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.domain.UserVO;

public interface StoreService {

	public void StoreRegister(StoreVO vo) throws Exception;
	public StoreVO StoreDetail(String userId);
	public void StoreUpdate(StoreVO vo);
	public void StoreDelete(String id);
}
