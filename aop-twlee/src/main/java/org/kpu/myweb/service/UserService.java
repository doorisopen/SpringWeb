package org.kpu.myweb.service;

import java.util.Map;

import org.kpu.myweb.domain.UserVO;

public interface UserService {
	
	public void UserRegister(UserVO vo) throws Exception;
	public int UserCheck(Map<String, Object> map) throws Exception;
	public UserVO UserDetail(String userId);
	public void UserUpdate(UserVO vo);
	public void UserDelete(String id);
	
}
