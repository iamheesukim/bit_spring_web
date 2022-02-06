package com.bitcamp.seoul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.seoul.board.BoardDAO;
import com.bitcamp.seoul.board.PagingVO;

@Controller
public class HomeController {
	BoardDAO dao = new BoardDAO();

	@RequestMapping("/")
	public ModelAndView boardList(PagingVO pVo) {
		ModelAndView mav = new ModelAndView();

		// ÃÑ·¹ÄÚµå¼ö
		dao.totalRecordCount(pVo);

		mav.addObject("pVo", pVo);
		mav.addObject("list", dao.boardPageSelect(pVo));
		mav.setViewName("index");

		return mav;
	}

}
