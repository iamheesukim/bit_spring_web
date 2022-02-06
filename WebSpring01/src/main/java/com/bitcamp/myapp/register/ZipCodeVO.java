package com.bitcamp.myapp.register;

public class ZipCodeVO {
	private String zipcode;
	private String sido;
	private String sigungu;
	private String doro;
	
	private int num1;
	private int num2;
	
	private String build;
	private String dong;
	
	private String zipcodeFull;
	
	public String getZipcodeFull() {
		zipcodeFull = zipcode+" "+sido+" "+sigungu+" "+doro+" "+num1;
		if(num2!=0) zipcodeFull+="-"+num2;
		zipcodeFull += " "+build+" ("+dong+")";
		return zipcodeFull;
	}
	public void setZipcodeFull(String zipcodeFull) {
		this.zipcodeFull = zipcodeFull;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getDoro() {
		return doro;
	}
	public void setDoro(String doro) {
		this.doro = doro;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}

}
