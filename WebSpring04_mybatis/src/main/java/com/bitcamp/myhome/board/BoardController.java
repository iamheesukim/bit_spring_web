package com.bitcamp.myhome.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//�۸��
	@RequestMapping("/list")
	public ModelAndView list() {

		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("list",dao.boardAllSelect());
		mav.setViewName("board/list");

		return mav;
	}

	//�� ���뺸��
	@RequestMapping("/view")
	public ModelAndView view(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("vo",dao.boardView(no)); //����������
		mav.setViewName("board/view"); //jsp
		return mav;
	}

	//�۾��������� �̵�
	@RequestMapping("/write")
	public String write() {
		//�̰� DB �۾��� �ʿ��� �ٷ� jsp�� ������ �̵�
		return "board/write";
	}

	//�۾��� �Ϸ�(����)
	@RequestMapping(value="/writeOk", method=RequestMethod.POST)	//ip������ �޾ƿ�
	public ModelAndView writeOk(BoardVO vo, HttpSession ses, HttpServletRequest req) {
		vo.setUserid((String)ses.getAttribute("userid"));
		vo.setIp(req.getRemoteAddr());
		//���� ������ form���� �޾ƿ�

		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class); //�߻�Ŭ���� ��ü�� ����� ��������
		int cnt = dao.boardWriteOk(vo);

		if(cnt>0) {//�۵��
			mav.setViewName("redirect:list"); //�Խ��Ǹ������ ��
		}else {//��Ͻ���
			mav.addObject("msg","���");
			mav.setViewName("board/writeResult"); //jsp
		}

		return mav;
	}

	//�� ���� ��
	@RequestMapping("/edit")
	public ModelAndView edit(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);

		mav.addObject("vo",dao.boardView(no));
		mav.setViewName("board/edit");
		return mav;
	}

	//�ۼ���
	@RequestMapping(value="/editOk", method=RequestMethod.POST)
	public ModelAndView editOk(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("userid"));
		
		//Ȯ�ο�
		//System.out.println(vo.getUserid());
		//System.out.println(vo.getSubject());
		//System.out.println(vo.getContent());
		//System.out.println(vo.getNo());

		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt =  dao.boardEditOk(vo);
		mav.addObject("no", vo.getNo());

		if(cnt>0) {//�� ������ �Ǹ� �� ���� ����
			mav.setViewName("redirect:view");
		}else {//���� �ȵǸ� �ۼ������� �̵�
			mav.addObject("msg","����");
			mav.setViewName("board/writeResult");

		}
		return mav;
	}


	//�ۻ���
	@RequestMapping("/boardDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		String userid = (String)session.getAttribute("userid");

		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt = dao.boardDelete(no, userid);

		ModelAndView mav = new ModelAndView();

		if(cnt>0) {//�� �����Ǹ� ����Ʈ
			mav.setViewName("redirect:list");
		}else {//�� ���� �ȵǸ� �� ���� ����
			mav.addObject("no",no);
			mav.setViewName("redirect:view");
		}
		return mav;
	}

}
