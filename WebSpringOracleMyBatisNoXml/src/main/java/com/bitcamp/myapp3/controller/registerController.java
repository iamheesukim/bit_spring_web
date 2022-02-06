package com.bitcamp.myapp3.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myapp3.service.RegisterService;
import com.bitcamp.myapp3.vo.RegisterVO;

@Controller
public class registerController {
	@Inject
	RegisterService registerService;
	
	//로그인폼
	@RequestMapping("/login")
	public String login() {
		return "register/login";
	}
	
	//로그인(전송)
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public ModelAndView loginOk(RegisterVO vo, HttpSession session) {
		
		RegisterVO resultVO = registerService.login(vo);
		ModelAndView mav = new ModelAndView();
		
		if(resultVO==null) {//로그인 실패
			mav.setViewName("redirect:login");
		}
		else {//로그인 성공
			session.setAttribute("logid", resultVO.getUserid());
			session.setAttribute("logname", resultVO.getUsername());
			mav.setViewName("redirect:/");
		}
		return mav;
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession s) {
		s.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		
		return mav;
	}

}
