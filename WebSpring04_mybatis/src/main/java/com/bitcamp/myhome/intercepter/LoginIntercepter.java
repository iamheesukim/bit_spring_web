package com.bitcamp.myhome.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {
	//컨트롤러가 호출되기전에 호출되는 메서드 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		//로그인 여부를 확인하여 로그인이 안된 경우, 로그인폼으로 이동
		//로그인이 된 경우는 접속한 컨트롤러로 구현
		
		//로그인된 아이디 구하기
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		
		//로그인이 안된 경우
		if(userid==null || userid.equals("")) {
			//						/myhome
			response.sendRedirect(request.getContextPath()+"/");
		}
		//로그인이 된 경우 : 가던길간다. 어디로? 접속한 컨트롤러 매핑주소로 이동.
		return true;
	}

	//컨트롤러가 실행된 후 view 페이지로 이동하기 전에 호출된다.

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			@Nullable ModelAndView modelAndview ) throws Exception {

	}

	//컨트롤러가 실행후 호출된다.

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception{

	}

}