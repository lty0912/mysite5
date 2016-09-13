package kr.ac.sungkyul.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.service.BBSService;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Controller
@RequestMapping("/bbs")
public class BBSController {
	
	@Autowired
	private BBSService bbsService;
	
	// 쓰기폼
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		
		
		
		return "board/write";
	}
	
	// 글등록
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerBoard(BoardVo boardVo, MultipartFile file) throws Exception {
		
		bbsService.insertBoard(boardVo, file);
		
		return "redirect:list";
	}
	
	// 글목록
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String listBoard(Model model) {
		
		List<BoardVo> listBoard = bbsService.listBoard();
		      
		//jsp에 넘겨준다.
		model.addAttribute( "listBoard", listBoard ); //jsp에서 쓸 이름, 넘겨줄 애(실제 데이터)
      
		return "board/list";
	}
	
	// 글보기
	@RequestMapping(value="view", method=RequestMethod.GET)
	public String readBoard(Long no, Model model) {
		
		BoardVo boardVo = bbsService.selectBoard(no);
		
		model.addAttribute("boardVo", boardVo);
		
		return "board/view";
	}
	
	// 글 수정 폼
	@RequestMapping(value="modifyform", method=RequestMethod.GET)
	public String modifyFormBoard(Long no, Model model) {
		
		BoardVo boardVo = bbsService.selectBoard(no);
		System.out.println(boardVo.toString());
		
		model.addAttribute("boardVo", boardVo);
		return "board/modify";
	}
	
	// 글 수정
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modifyBoard(BoardVo vo) {
		System.out.println("컨트롤러 modify");
		bbsService.updateBoard(vo);
		
		return "redirect:list";
	}
	
	// 글 삭제
		@RequestMapping(value="deleteBoard", method=RequestMethod.GET)
		public String delete(Long no) {
			bbsService.deleteBoard(no);
			
			return "redirect:list";
		}
	
	
}
