package com.campus.myapp.vo;

public class AdminVO {
	private String empid;
	private String emppwd;
	
	private String email;
	private String email1;
	private String email2;
	
	private String empname;
	
	private String empbirth;
	private String year;
	private String month;
	private String day;
	
	private String gender;
	private String tel;
	private String writedate;
	
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmppwd() {
		return emppwd;
	}
	public void setEmppwd(String emppwd) {
		this.emppwd = emppwd;
	}
	public String getEmail() {
		// email1, email2를 하나의 데이터로 get할때 만들어준다.
		email = email1 + "@" + email2;
		return email;
	}
	public void setEmail(String email) {
		// DB이메일 aaaaa@naver.com -> @기준으로 나눠준다.
		String[] emailSp = email.split("@");
		email1 = emailSp[0];
		email2 = emailSp[1];
		this.email = email;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpbirth() {
		empbirth = year + "/" + month + "/" + day;
		return empbirth;
	}
	public void setEmpbirth(String empbirth) {
		String[] birthSp = empbirth.split("/");
		year = birthSp[0];
		month = birthSp[1];
		day = birthSp[2];
		this.empbirth = empbirth;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	
}
