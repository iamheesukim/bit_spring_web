package com.bitcamp.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.myapp.service.MemberService;
import com.bitcamp.myapp.vo.MemberVO;

@Controller
public class MemberController {
	
	@Inject //객체 생성 가능하게 해줌
	MemberService memberService;
	
	@RequestMapping("/login")
	public String loginForm() {
		return "register/loginForm";
	}
	
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public String loginOk(MemberVO vo, HttpSession ses) {
		
		//로그인 (DB조회)
		MemberVO resultVo = memberService.loginSelect(vo); //로그인된 아이디와 비번
		
		//세션처리
		if(resultVo != null) {//로그인 성공
			ses.setAttribute("userid", resultVo.getUserid());
			ses.setAttribute("username", resultVo.getUsername());
		}
		
		return "home";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "home";
	}
}
