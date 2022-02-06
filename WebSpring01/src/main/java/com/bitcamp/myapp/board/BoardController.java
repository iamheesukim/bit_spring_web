package com.bitcamp.myapp.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	BoardDAO dao = new BoardDAO();

	@RequestMapping("/boardList")
	public ModelAndView boardList(PagingVO pVo) {
		ModelAndView mav = new ModelAndView();

		// 총레코드수
		dao.totalRecordCount(pVo);

		mav.addObject("pVo", pVo);
		mav.addObject("list", dao.boardPageSelect(pVo));
		mav.setViewName("board/boardList");

		return mav;
	}

	//글 내용보기
	@RequestMapping("/boardView")
	public ModelAndView boardView(BoardVO vo, PagingVO pVo) {
		ModelAndView mav = new ModelAndView();

		dao.boardSelect(vo); //레코드 선택
		mav.addObject("vo",vo); //넘겨주는이름 / 넘겨주는것
		mav.addObject("pVo",pVo);
		mav.setViewName("board/boardView");

		return mav;
	}

	//ajax로 구현
	//댓글쓰기
	//POST 방식은 이렇게 길게 작성하기
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	@ResponseBody
	public int replyWrite(ReplyBoardVO replyVo, HttpSession ses) {
		//댓글 작성자를 session에서 얻어오기
		replyVo.setUserid((String)ses.getAttribute("logid"));
		return dao.replyInsert(replyVo);

	}

	//댓글목록
	@RequestMapping(value = "/replyList")
	@ResponseBody
	public List<ReplyBoardVO>replyList(int no) {
		return dao.replyListSelect(no);
	}

	//댓글 수정
	@RequestMapping(value="/replyEditOk", method=RequestMethod.POST)
	@ResponseBody
	public int replyEditOk(ReplyBoardVO replyVo, HttpSession ses) {
		replyVo.setUserid((String)ses.getAttribute("logid"));
		return dao.replyUpdate(replyVo);
	}
	//댓글 삭제
	@RequestMapping(value="/replyDel")
	@ResponseBody
	public int replyDel(int num, HttpSession ses) {
		return dao.replyDelete(num, (String)ses.getAttribute("logid"));
	}
}