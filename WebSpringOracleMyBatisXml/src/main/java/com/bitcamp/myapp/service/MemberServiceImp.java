package com.bitcamp.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.myapp.dao.MemberDAO;
import com.bitcamp.myapp.vo.MemberVO;
@Service
public class MemberServiceImp implements MemberService {
	@Inject //��ü��������
	MemberDAO memberDAO;

	@Override
	public MemberVO loginSelect(MemberVO vo) { //�α���
		// dao�� �޼ҵ带 ȣ��
		return memberDAO.loginSelect(vo);
		//memberDAO�� ����Ǹ� Mapper���� �޼ҵ� ã�Ƽ� �����
	}

}
