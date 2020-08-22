package com.hoony.lab.dto;

public class Student {

	private int s_id;
	private String s_name;
	private int s_grade;
	private String s_department;
	private String s_address;
	private String s_phone;

	public Student(int s_id, String s_name, int s_grade, String s_department, String s_address, String s_phone) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_grade = s_grade;
		this.s_department = s_department;
		this.s_address = s_address;
		this.s_phone = s_phone;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_grade=" + s_grade + ", s_department="
				+ s_department + ", s_address=" + s_address + ", s_phone=" + s_phone + "]";
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_grade() {
		return s_grade;
	}

	public void setS_grade(int s_grade) {
		this.s_grade = s_grade;
	}

	public String getS_department() {
		return s_department;
	}

	public void setS_department(String s_department) {
		this.s_department = s_department;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_phone() {
		return s_phone;
	}

	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}

}
