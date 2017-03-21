package com.bvp.daafobs.beans;

public class Student {

	private int prn;
	private String name;
	private String password;
	private String semester;

	public Student() {
		super();
	}

	public Student(int prn, String name, String password, String semester) {
		super();
		this.prn = prn;
		this.name = name;
		this.password = password;
		this.semester = semester;
	}

	public Student(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public int getPrn() {
		return prn;
	}

	public void setPrn(int prn) {
		this.prn = prn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", password=" + password + ", semester=" + semester + "]";
	}

}
