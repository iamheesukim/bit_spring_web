package com.bitcamp.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.MemberDAO;
import com.bitcamp.myapp.vo.MemberVO;
@Service
public class MemberServiceImp implements MemberService {
	@Inject //객체생성해줌
	MemberDAO memberDAO;

	@Override
	public MemberVO loginSelect(MemberVO vo) { //로그인
		// dao의 메소드를 호출
		return memberDAO.loginSelect(vo);
		//memberDAO가 실행되면 Mapper에서 메소드 찾아서 실행됨
	}

}
