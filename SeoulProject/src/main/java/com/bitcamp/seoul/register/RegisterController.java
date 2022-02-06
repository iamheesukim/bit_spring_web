package com.bitcamp.seoul.register;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller // 컨트롤러 객체가 됨 (상속받는 느낌)
public class RegisterController {
	RegisterDAO dao = new RegisterDAO();

	// 로그인
	@RequestMapping(value = "loginOk", method = RequestMethod.POST)
	public ModelAndView loginOk(HttpServletRequest req, RegisterVO vo) {
		dao.loginSelect(vo);

		ModelAndView mav = new ModelAndView();
		if (vo.getLogStatus() == "Y") { // 로그인 성공 - 로그인폼으로
			System.out.println(vo.getUserid());
			HttpSession session = req.getSession();
			// 이름, 로그인 상태
			session.setAttribute("logname", vo.getUsername());
			session.setAttribute("logid", vo.getUserid());
			session.setAttribute("logStatus", vo.getLogStatus());

			mav.setViewName("register/loginOk");
		} else { // 로그인 실패 - 홈으로
			mav.setViewName("register/loginOk");
		}
		return mav;
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

}
