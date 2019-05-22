package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.BoardVO;
import org.kpu.myweb.persistence.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	
	@Autowired
	private BoardDAO boardDAO;
	
	/*
	 * 게시글 등록
	 * 
	 */
	public int BoardRegister(BoardVO vo) throws Exception {
		return boardDAO.BoardRegister(vo);
	}
	
	/*
	 * 게시글 리스트
	 * 
	 */
	public List<BoardVO> BoardList(BoardVO vo) throws Exception {
		return boardDAO.BoardList(vo);
	}
	
	/*
	 * 게시글 상세조회
	 * 
	 */
	public BoardVO BoardDetail(int boardIdx) {
		return boardDAO.BoardDetail(boardIdx);
	}

	/*
	 * 게시글 수정
	 * 
	 */
	public void BoardUpdate(BoardVO vo) {
		boardDAO.BoardUpdate(vo);
		
	}

	/*
	 * 게시글 삭제
	 * 
	 */
	public void BoardDelete(int boardIdx) {
		boardDAO.BoardDelete(boardIdx);
		
	}

	

}
