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

	//��ҿ� mav�� �����ϴµ� �̹��� �� ���..

	//�Խ��� ���
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("list",boardService.boardList());
		return "board/list";
	}

	//�Խñ� ����
	@RequestMapping("/boardView")
	public String boardView(Model model, int no) {
		model.addAttribute("vo", boardService.boardView(no));
		return "board/boardView";
	}

	//�۾�����
	@RequestMapping("/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}

	//�� ���
	@RequestMapping(value="/boardWriteOk", method=RequestMethod.POST)
	public ModelAndView boardWriteOk(BoardVO vo, HttpSession session, HttpServletRequest req) {
		vo.setUserid((String)session.getAttribute("logid"));
		vo.setIp(req.getRemoteAddr());

		int cnt = boardService.boardInsert(vo);
		ModelAndView mav = new ModelAndView();

		if(cnt>0) {//�۾��� ����
			mav.setViewName("redirect:boardList");
		} else {//�۾��� ����
			mav.setViewName("redirect:boardWrite"); //������ �̷��� �ϸ� �ȵǰ�.. history�ؼ� ������
		}

		return mav;
	}

	//�� ����
	@RequestMapping("/boardEdit")
	public ModelAndView boardEdit(int no) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("vo", boardService.boardView(no));

		//boardService.boardView(no).getNo();

		mav.setViewName("board/boardEdit");

		return mav;
	}

	//�� ���� ����
	@RequestMapping(value="/boardEditOk", method=RequestMethod.POST)
	public ModelAndView boardEditOk(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logid"));

		int result = boardService.boardUpdate(vo);

		ModelAndView mav = new ModelAndView();
		if(result>0) {//���� ����
			mav.addObject("no",vo.getNo());
			mav.setViewName("redirect:boardView");
		} else {//����
			mav.setViewName("board/result");
		}

		return mav;
	}

	//�� ����
	@RequestMapping("/boardDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		String userid = (String)session.getAttribute("logid");
		int cnt = boardService.boardDelete(no, userid);

		ModelAndView mav = new ModelAndView();

		if(cnt>0) {//���� ����
			mav.setViewName("redirect:boardList");
		} else {//���� ����
			mav.addObject("no",no);
			mav.setViewName("redirect:boardView");
		}

		return mav;
	}

	//���� ���ڵ带 �迭�� �����ϱ�
	@RequestMapping(value="/arrayBoardDel", method=RequestMethod.POST )
	public ModelAndView arrayBoardDel(BoardVO vo) {

		ModelAndView mav= new ModelAndView();
		int result = boardService.boardDelArray(vo.getNoDelArray());//�����ʹ� �迭�� �Ѱ��ָ� �Ǵϱ�
		System.out.println("������ �迭 ���ڵ�� :"+result);

		mav.setViewName("redirect:/boardList");
		return mav;
	}
	
	@RequestMapping(value="/listBoardDel", method=RequestMethod.POST)
	public ModelAndView listBoardDel(BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		int cnt = boardService.boardDelList(vo.getNoDelList());
		
		System.out.println("������ ����Ʈ ���ڵ�� :"+cnt);
		
		mav.setViewName("redirect:/boardList");
		return mav;
	}


}