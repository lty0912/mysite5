package kr.ac.sungkyul.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.mysite.vo.AttachFileVo;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Repository
public class BBSDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public Long insertBoard(BoardVo boardVo) {
		sqlSession.insert("bbs.insertBoard", boardVo);	// 파라미터 첫번째 값은 xml에 ID값, 두번째는 넘길 변수
		return boardVo.getNo();
	}
	
	public void insertAttachFileVo(AttachFileVo attachFileVo) {
		sqlSession.insert("bbs.insertAttachFile", attachFileVo);
	}
	
	public List<BoardVo> listBoard() {
		List<BoardVo> list = sqlSession.selectList("bbs.listBoard");
		return list;
	}
	
	public BoardVo selectBoard(Long no) {
		BoardVo boardVo = sqlSession.selectOne("bbs.selectBoard", no);
		return boardVo;
	}
	
	public void updateBoard(BoardVo vo) {
		System.out.println("DAO updateBoard");
		sqlSession.update("bbs.updateBoard", vo);
	}
	
	public void deleteBoard(Long no) {
		sqlSession.delete("bbs.deleteBoard", no);
	}
	

}
