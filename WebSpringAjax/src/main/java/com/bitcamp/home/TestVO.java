package com.bitcamp.home;

public class TestVO {
	private int num;
	private String userid;
	private String nick;
	
	public TestVO() {}
	public TestVO(int num, String userid, String nick) {
		this.num = num;
		this.userid = userid;
		this.nick = nick;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	

}
