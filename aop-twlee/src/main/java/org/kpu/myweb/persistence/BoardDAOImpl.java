package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.BoardVO;
import org.kpu.myweb.domain.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	private static final String namespace ="org.kpu.myweb.BoardMapper";
	
	/*
	 * 게시글 등록
	 * 
	 */
	public int BoardRegister(BoardVO vo) throws Exception {
		return sqlSession.insert(namespace + ".BoardRegister", vo);
	}
	
	/*
	 * 게시글 리스트
	 * 
	 */
	public List<BoardVO> BoardList(BoardVO vo) throws Exception {
		List<BoardVO> BoardList = new ArrayList<BoardVO>();
		BoardList = sqlSession.selectList(namespace + ".BoardList", vo);
		return BoardList;
	}
	
	/*
	 * 게시글 상세조회
	 * 
	 */
	public BoardVO BoardDetail(int boardIdx) {
		return sqlSession.selectOne(namespace+".BoardDetail", boardIdx);
	}
	
	/*
	 * 게시글 수정
	 * 
	 */
	public void BoardUpdate(BoardVO vo) {
		sqlSession.update(namespace + ".BoardUpdate", vo);
	}
	
	/*
	 * 게시글 삭제
	 * 
	 */
	public void BoardDelete(int boardIdx) {
		sqlSession.delete(namespace + ".BoardDelete", boardIdx);
	}

}
