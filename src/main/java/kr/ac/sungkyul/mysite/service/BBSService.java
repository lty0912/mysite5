package kr.ac.sungkyul.mysite.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.dao.BBSDAO;
import kr.ac.sungkyul.mysite.vo.AttachFileVo;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Service
public class BBSService {
	
	@Autowired
	private BBSDAO bbsDAO;
	
	public void insertBoard(BoardVo boardVo, MultipartFile file) throws IOException{
		
		// 게시글 저장 후 글 no 가져옴
		Long bbsNo = bbsDAO.insertBoard(boardVo);
		
		// orgName
		String orgName = file.getOriginalFilename();
		
		// fileSize
		Long fileSize = file.getSize();
		
		// saveName
		String saveName = UUID.randomUUID().toString() + "_" + orgName;
		
		// path
		String path = "C:\\upload";
		
		AttachFileVo attachFileVo = new AttachFileVo();
		
		attachFileVo.setBbsNo(bbsNo);
		attachFileVo.setOrgName(orgName);
		attachFileVo.setFileSize(fileSize);
		attachFileVo.setSaveName(saveName);
		attachFileVo.setPath(path);
		
		bbsDAO.insertAttachFileVo(attachFileVo);
		
		File target = new File(path, saveName);
		FileCopyUtils.copy(file.getBytes(), target);
		
		
		
		
	}
	
	public List<BoardVo> listBoard() {
		List<BoardVo> listBoard = bbsDAO.listBoard();
		return listBoard;
	}
	
	public BoardVo selectBoard(Long no) {
		BoardVo boardVo = bbsDAO.selectBoard(no);
		return boardVo;
	}
	
	public void updateBoard(BoardVo vo) {
		bbsDAO.updateBoard(vo);
	}
	
	public void deleteBoard(Long no) {
		bbsDAO.deleteBoard(no);
	}
	
}
