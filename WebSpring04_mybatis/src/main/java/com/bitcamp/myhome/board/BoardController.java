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

	//글목록
	@RequestMapping("/list")
	public ModelAndView list() {

		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("list",dao.boardAllSelect());
		mav.setViewName("board/list");

		return mav;
	}

	//글 내용보기
	@RequestMapping("/view")
	public ModelAndView view(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		mav.addObject("vo",dao.boardView(no)); //가져갈정보
		mav.setViewName("board/view"); //jsp
		return mav;
	}

	//글쓰기폼으로 이동
	@RequestMapping("/write")
	public String write() {
		//이건 DB 작업이 필요없어서 바로 jsp로 페이지 이동
		return "board/write";
	}

	//글쓰기 완료(전송)
	@RequestMapping(value="/writeOk", method=RequestMethod.POST)	//ip때문에 받아옴
	public ModelAndView writeOk(BoardVO vo, HttpSession ses, HttpServletRequest req) {
		vo.setUserid((String)ses.getAttribute("userid"));
		vo.setIp(req.getRemoteAddr());
		//제목 내용은 form에서 받아옴

		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class); //추상클래스 객체를 만들어 리턴해줌
		int cnt = dao.boardWriteOk(vo);

		if(cnt>0) {//글등록
			mav.setViewName("redirect:list"); //게시판목록으로 감
		}else {//등록실패
			mav.addObject("msg","등록");
			mav.setViewName("board/writeResult"); //jsp
		}

		return mav;
	}

	//글 수정 폼
	@RequestMapping("/edit")
	public ModelAndView edit(int no) {
		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);

		mav.addObject("vo",dao.boardView(no));
		mav.setViewName("board/edit");
		return mav;
	}

	//글수정
	@RequestMapping(value="/editOk", method=RequestMethod.POST)
	public ModelAndView editOk(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("userid"));
		
		//확인용
		//System.out.println(vo.getUserid());
		//System.out.println(vo.getSubject());
		//System.out.println(vo.getContent());
		//System.out.println(vo.getNo());

		ModelAndView mav = new ModelAndView();
		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt =  dao.boardEditOk(vo);
		mav.addObject("no", vo.getNo());

		if(cnt>0) {//글 수정이 되면 글 내용 보기
			mav.setViewName("redirect:view");
		}else {//수정 안되면 글수정으로 이동
			mav.addObject("msg","수정");
			mav.setViewName("board/writeResult");

		}
		return mav;
	}


	//글삭제
	@RequestMapping("/boardDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		String userid = (String)session.getAttribute("userid");

		BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
		int cnt = dao.boardDelete(no, userid);

		ModelAndView mav = new ModelAndView();

		if(cnt>0) {//글 삭제되면 리스트
			mav.setViewName("redirect:list");
		}else {//글 삭제 안되면 글 내용 보기
			mav.addObject("no",no);
			mav.setViewName("redirect:view");
		}
		return mav;
	}

}
