package com.bitcamp.myhome.register;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@RequestMapping(value="/loginOK", method=RequestMethod.POST)
	public String loginOk(RegisterVO vo, HttpSession ses) {
		
		//로그인
		//xml과 추상클래스를 매핑하여 추상클래스를 리턴 받음
		RegisterDAOImp dao = sqlSession.getMapper(RegisterDAOImp.class);
		//메소드 실행 - 선택레코드가 없을 경우 null이 리턴되고, 선택 레코드가 있으면 vo리턴된다.
		RegisterVO logVo = dao.loginCheck(vo);
		
		//세션저장
		if(logVo!=null) { //로그인 성공
			ses.setAttribute("username", logVo.getUsername());
			ses.setAttribute("userid", logVo.getUserid());
			System.out.println(logVo.getUsername());
		}else { //로그인 실패
			//딱히 할게 없음
		}
		return "home";
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession ses) {
		ses.invalidate();
		return "home";
	}

}
