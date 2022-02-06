package com.bitcamp.app.register;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	//@Autowired
	//	public RegisterDAO dao;
	public RegisterDAO dao = new RegisterDAO(); 
	//로그인폼
	@RequestMapping("/login")
	public String login() {
		return "register/login";
	}
	//로그인 확인
	@RequestMapping(value="/loginOk",method=RequestMethod.POST)
	public ModelAndView loginOk(RegisterVO vo,HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		dao.login(vo);
		RegisterVO logVo= dao.login(vo);
		//session처리
		if(logVo!=null) {
			ses.setAttribute("userid", logVo.getUserid());
			ses.setAttribute("username", logVo.getUsername());
		}
		mav.setViewName("redirect:/");
		return mav;
	}
}