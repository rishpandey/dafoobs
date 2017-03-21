package com.bvp.daafobs.beans;

public class Result {

	private String prn;
	private String subject1;
	private String subject2;
	private String subject3;
	private String subject4;
	private String subject5;
	private String subject6;
	private String subject7;
	private String semester;

	public Result() {
		super();
	}

	public Result(String prn, String subject1, String subject2, String subject3, String subject4, String subject5,
			String subject6, String subject7, String semester) {
		super();
		this.prn = prn;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
		this.subject6 = subject6;
		this.subject7 = subject7;
		this.semester = semester;
	}
	
	

	public Result(String prn, String subject1, String subject2, String subject3, String subject4, String subject5,
			String subject6, String subject7) {
		super();
		this.prn = prn;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
		this.subject6 = subject6;
		this.subject7 = subject7;
	}

	public String getPrn() {
		return prn;
	}

	public void setPrn(String prn) {
		this.prn = prn;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	public String getSubject4() {
		return subject4;
	}

	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}

	public String getSubject5() {
		return subject5;
	}

	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}

	public String getSubject6() {
		return subject6;
	}

	public void setSubject6(String subject6) {
		this.subject6 = subject6;
	}

	public String getSubject7() {
		return subject7;
	}

	public void setSubject7(String subject7) {
		this.subject7 = subject7;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Result [prn=" + prn + ", subject1=" + subject1 + ", subject2=" + subject2 + ", subject3=" + subject3
				+ ", subject4=" + subject4 + ", subject5=" + subject5 + ", subject6=" + subject6 + ", subject7="
				+ subject7 + ", semester=" + semester + "]";
	}

}
