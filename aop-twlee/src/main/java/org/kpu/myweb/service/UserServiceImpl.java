package org.kpu.myweb.service;

import java.util.Map;

import org.kpu.myweb.domain.UserVO;
import org.kpu.myweb.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	/*
	 * 사용자 등록
	 * 
	 */
	public void UserRegister(UserVO vo) throws Exception {
		userDAO.UserRegister(vo);
	}
	/*
	 * 아이디 등록 조회
	 * 
	 */
	public int UserCheck(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.UserCheck(map);
	}

}
