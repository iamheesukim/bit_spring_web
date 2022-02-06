package com.bitcamp.myhome.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {
	//��Ʈ�ѷ��� ȣ��Ǳ����� ȣ��Ǵ� �޼��� 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		//�α��� ���θ� Ȯ���Ͽ� �α����� �ȵ� ���, �α��������� �̵�
		//�α����� �� ���� ������ ��Ʈ�ѷ��� ����
		
		//�α��ε� ���̵� ���ϱ�
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		
		//�α����� �ȵ� ���
		if(userid==null || userid.equals("")) {
			//						/myhome
			response.sendRedirect(request.getContextPath()+"/");
		}
		//�α����� �� ��� : �����氣��. ����? ������ ��Ʈ�ѷ� �����ּҷ� �̵�.
		return true;
	}

	//��Ʈ�ѷ��� ����� �� view �������� �̵��ϱ� ���� ȣ��ȴ�.

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			@Nullable ModelAndView modelAndview ) throws Exception {

	}

	//��Ʈ�ѷ��� ������ ȣ��ȴ�.

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception{

	}

}