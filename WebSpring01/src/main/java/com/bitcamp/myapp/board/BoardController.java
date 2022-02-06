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

		// �ѷ��ڵ��
		dao.totalRecordCount(pVo);

		mav.addObject("pVo", pVo);
		mav.addObject("list", dao.boardPageSelect(pVo));
		mav.setViewName("board/boardList");

		return mav;
	}

	//�� ���뺸��
	@RequestMapping("/boardView")
	public ModelAndView boardView(BoardVO vo, PagingVO pVo) {
		ModelAndView mav = new ModelAndView();

		dao.boardSelect(vo); //���ڵ� ����
		mav.addObject("vo",vo); //�Ѱ��ִ��̸� / �Ѱ��ִ°�
		mav.addObject("pVo",pVo);
		mav.setViewName("board/boardView");

		return mav;
	}

	//ajax�� ����
	//��۾���
	//POST ����� �̷��� ��� �ۼ��ϱ�
	@RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
	@ResponseBody
	public int replyWrite(ReplyBoardVO replyVo, HttpSession ses) {
		//��� �ۼ��ڸ� session���� ������
		replyVo.setUserid((String)ses.getAttribute("logid"));
		return dao.replyInsert(replyVo);

	}

	//��۸��
	@RequestMapping(value = "/replyList")
	@ResponseBody
	public List<ReplyBoardVO>replyList(int no) {
		return dao.replyListSelect(no);
	}

	//��� ����
	@RequestMapping(value="/replyEditOk", method=RequestMethod.POST)
	@ResponseBody
	public int replyEditOk(ReplyBoardVO replyVo, HttpSession ses) {
		replyVo.setUserid((String)ses.getAttribute("logid"));
		return dao.replyUpdate(replyVo);
	}
	//��� ����
	@RequestMapping(value="/replyDel")
	@ResponseBody
	public int replyDel(int num, HttpSession ses) {
		return dao.replyDelete(num, (String)ses.getAttribute("logid"));
	}
}