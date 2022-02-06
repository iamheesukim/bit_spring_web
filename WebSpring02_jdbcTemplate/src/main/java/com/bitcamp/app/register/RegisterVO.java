package com.bitcamp.app.register;

public class RegisterVO {
   private String userid;
   private String userpwd;
   private String username;
   private int cnt;
   
   public String getUserid() {
      return userid;
   }
   public void setUserid(String userid) {
      this.userid = userid;
   }
   public String getUserpwd() {
      return userpwd;
   }
   public void setUserpwd(String userpwd) {
      this.userpwd = userpwd;
   }
   public String getUsername() {
      return username;
   }
   public void setUsername(String username) {
      this.username = username;
   }
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
   
}