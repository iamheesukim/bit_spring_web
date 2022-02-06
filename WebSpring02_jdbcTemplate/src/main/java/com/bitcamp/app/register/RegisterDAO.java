package com.bitcamp.app.register;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.app.Constants;

public class RegisterDAO implements RegisterDAOImp {
	public JdbcTemplate template;


	public JdbcTemplate getTemplate() {
		return template;
	}


	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public RegisterDAO() {
		this.template = Constants.template;
	}
	//========================================================
	@Override
	public RegisterVO login(RegisterVO vo) {
		//데이터가 있는지 확인
		String sql="select count(userid) cnt from register where userid=? and userpwd=?";
		RegisterVO logVO = template.queryForObject(sql, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class),vo.getUserid(),vo.getUserpwd());

		if(logVO.getCnt()>0) {
			sql="select userid, username from register where userid=? and userpwd=?";
			//아이디,비번을 매개변수로하면 결과로 vo 가 돌아와야함(object)
			return template.queryForObject(sql, new BeanPropertyRowMapper<RegisterVO>(RegisterVO.class),vo.getUserid(),vo.getUserpwd());
		
		}else {
			return null;
		}
	}
}