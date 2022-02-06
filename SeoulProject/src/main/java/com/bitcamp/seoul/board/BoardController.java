package com.bitcamp.seoul.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	BoardDAO dao = new BoardDAO();

	@RequestMapping("/boardList")
	public ModelAndView boardList(PagingVO pVo) {
		ModelAndView mav = new ModelAndView();

		// ÃÑ·¹ÄÚµå¼ö
		dao.totalRecordCount(pVo);

		mav.addObject("pVo", pVo);
		mav.addObject("list", dao.boardPageSelect(pVo));
		mav.setViewName("board/boardList");

		return mav;
	}

}