package com.bitcamp.myapp3.dao;

import org.apache.ibatis.annotations.Select;

import com.bitcamp.myapp3.vo.RegisterVO;
//���񽺿� �״�� ����
public interface RegisterDAO {
	
	@Select("select userid, username from register where userid=#{userid} and userpwd=#{userpwd}")
	public RegisterVO login(RegisterVO vo);
}
