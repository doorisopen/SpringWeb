package org.kpu.myweb.persistence;

import java.util.Map;

import org.kpu.myweb.domain.UserVO;

public interface UserDAO {

	public int UserRegister(UserVO vo) throws Exception; 
	public int UserCheck(Map<String, Object> map) throws Exception;
}
