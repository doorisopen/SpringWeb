package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.BoardVO;

public interface BoardService {
	
	public int BoardRegister(BoardVO vo) throws Exception;
	public List<BoardVO> BoardList(BoardVO vo) throws Exception;
	public BoardVO BoardDetail(int boardIdx);
	public void BoardUpdate(BoardVO vo);
	public void BoardDelete(int boardIdx);
}
