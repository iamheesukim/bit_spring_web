package com.bitcamp.myapp3.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myapp3.service.BoardService;
import com.bitcamp.myapp3.vo.BoardVO;

@Controller
public class BoardController {

	@Inject
	BoardService boardService;

	//평소엔 mav로 리턴하는데 이번엔 이 방법..

	//게시판 목록
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("list",boardService.boardList());
		return "board/list";
	}

	//게시글 보기
	@RequestMapping("/boardView")
	public String boardView(Model model, int no) {
		model.addAttribute("vo", boardService.boardView(no));
		return "board/boardView";
	}

	//글쓰기폼
	@RequestMapping("/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}

	//글 등록
	@RequestMapping(value="/boardWriteOk", method=RequestMethod.POST)
	public ModelAndView boardWriteOk(BoardVO vo, HttpSession session, HttpServletRequest req) {
		vo.setUserid((String)session.getAttribute("logid"));
		vo.setIp(req.getRemoteAddr());

		int cnt = boardService.boardInsert(vo);
		ModelAndView mav = new ModelAndView();

		if(cnt>0) {//글쓰기 성공
			mav.setViewName("redirect:boardList");
		} else {//글쓰기 실패
			mav.setViewName("redirect:boardWrite"); //실제론 이렇게 하면 안되고.. history해서 보내기
		}

		return mav;
	}

	//글 수정
	@RequestMapping("/boardEdit")
	public ModelAndView boardEdit(int no) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("vo", boardService.boardView(no));

		//boardService.boardView(no).getNo();

		mav.setViewName("board/boardEdit");

		return mav;
	}

	//글 수정 전송
	@RequestMapping(value="/boardEditOk", method=RequestMethod.POST)
	public ModelAndView boardEditOk(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logid"));

		int result = boardService.boardUpdate(vo);

		ModelAndView mav = new ModelAndView();
		if(result>0) {//수정 성공
			mav.addObject("no",vo.getNo());
			mav.setViewName("redirect:boardView");
		} else {//실패
			mav.setViewName("board/result");
		}

		return mav;
	}

	//글 삭제
	@RequestMapping("/boardDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		String userid = (String)session.getAttribute("logid");
		int cnt = boardService.boardDelete(no, userid);

		ModelAndView mav = new ModelAndView();

		if(cnt>0) {//삭제 성공
			mav.setViewName("redirect:boardList");
		} else {//삭제 실패
			mav.addObject("no",no);
			mav.setViewName("redirect:boardView");
		}

		return mav;
	}

	//여러 레코드를 배열로 삭제하기
	@RequestMapping(value="/arrayBoardDel", method=RequestMethod.POST )
	public ModelAndView arrayBoardDel(BoardVO vo) {

		ModelAndView mav= new ModelAndView();
		int result = boardService.boardDelArray(vo.getNoDelArray());//데이터는 배열만 넘겨주면 되니깐
		System.out.println("삭제된 배열 레코드수 :"+result);

		mav.setViewName("redirect:/boardList");
		return mav;
	}
	
	@RequestMapping(value="/listBoardDel", method=RequestMethod.POST)
	public ModelAndView listBoardDel(BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		int cnt = boardService.boardDelList(vo.getNoDelList());
		
		System.out.println("삭제된 리스트 레코드수 :"+cnt);
		
		mav.setViewName("redirect:/boardList");
		return mav;
	}


}