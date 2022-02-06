package com.bitcamp.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired // @ Inject
	public BoardDAO dao;
	//public BoardDAO dao = new BoardDAO();

	@RequestMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",dao.allRecord());

		return mav;
	}

	//글 작성
	@RequestMapping("board/write")
	public String write() {
		return "board/write";
	}

	//글 작성 완료 (전송)
	@RequestMapping(value="/board/writeOk", method=RequestMethod.POST)
	public ModelAndView writeOk(BoardVO vo, HttpServletRequest req, HttpSession ses) {
		ModelAndView mav = new ModelAndView();

		vo.setIp(req.getRemoteAddr()); //ip
		vo.setUserid((String)ses.getAttribute("userid"));
		int result = dao.boardInsert(vo);

		mav.setViewName("redirect:list");

		return mav;
	}

	//게시판 보기
	@RequestMapping("/board/view")
	public ModelAndView view(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",dao.oneRecord(no));
		mav.setViewName("board/view");
		return mav;
	}
	

	//게시판 수정
	@RequestMapping("/board/edit")
	public ModelAndView edit(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",dao.oneRecord(no));
		mav.setViewName("board/edit");
		return mav;
	}

	//게시글 수정 완료 (전송)
	@RequestMapping(value="/board/editOk", method=RequestMethod.POST)
    public ModelAndView editOk(BoardVO vo) {
       ModelAndView mav = new ModelAndView();
       mav.addObject("no", vo.getNo());
       
       System.out.println(vo.getNo());
       
       int result = dao.boardUpdate(vo);
       if(result>0){//수정 시 글 내용보기로
          mav.setViewName("redirect:view");
       }else{//수정실패 시 글수정 폼으로
          mav.setViewName("redirect:edit");
       }
       return mav;
    }

	
	 @RequestMapping("/board/del")
	    public ModelAndView del(int no) {
	       ModelAndView mav = new ModelAndView();
	       int result = dao.boardDelete(no);
	       if(result>0) { //삭제한 경우
	          mav.setViewName("redirect:list");
	       }else { //삭제 못한 경우
	          mav.addObject("no", no);
	          mav.setViewName("redirect:view");
	       }
	       return mav;
	    }
}

