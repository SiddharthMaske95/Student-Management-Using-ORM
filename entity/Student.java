package com.spring.orm.entity;


import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name="student_details")
public class Student 
{
	@Id
	@Column(name="student_id")
 private int Studentid;
	@Column(name="student_name")
 private String studentName;
	@Column(name="student_city")
 private String studentCity;
	public Student(int studentid, String studentName, String studentCity) {
		super();
		Studentid = studentid;
		this.studentName = studentName;
		this.studentCity = studentCity;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentid() {
		return Studentid;
	}
	public void setStudentid(int studentid) {
		Studentid = studentid;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	
	
}
