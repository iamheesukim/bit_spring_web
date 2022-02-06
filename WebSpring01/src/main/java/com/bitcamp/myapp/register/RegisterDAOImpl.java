package com.bitcamp.myapp.register;

import java.util.List;

public interface RegisterDAOImpl {
	// 회원가입
	public int insertRecord(RegisterVO vo);
	
	// 회원정보 수정 시 기존 정보 선택 (레코드 1개)
	// public RegisterVO selectRecord(String userid); // 둘 중 아무거나 써도 됨
	public void selectRecord(RegisterVO vo); // 그냥 vo에 넣어주면 반환값 없이도 알아서 값을 불러올 수 있음
	
	// 회원정보 수정
	public int updateRecord(RegisterVO vo);
	
	// 로그인
	public void loginSelect(RegisterVO vo);
	
	// 아이디 중복 검사
	public int idDoubleCheck(String userid);
	
	// 도로명을 이용한 우편번호, 주소 검색
	public List<ZipCodeVO> zipSearchRecord(String doro);
}
