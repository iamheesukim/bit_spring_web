package com.bitcamp.myapp3.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitcamp.myapp3.dao.RegisterDAO;
import com.bitcamp.myapp3.vo.RegisterVO;

@Service
public class RegisterServiceImp implements RegisterService {
	@Inject
	RegisterDAO registerDAO;

	@Override
	public RegisterVO login(RegisterVO vo) {
		return registerDAO.login(vo);
	}

}
