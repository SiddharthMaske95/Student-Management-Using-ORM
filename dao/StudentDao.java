package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entity.Student;







 
public class StudentDao
{
	private HibernateTemplate hibernateTemplate;
	// save Student
	@Transactional
 public int insert(Student student)
 {
	 //insert
	 Integer i=(Integer)this.hibernateTemplate.save(student);
	 return i;
	 
 }
	// get the single data(object)
	public Student getStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class,studentId);	
		return student;		
	}
	//get all Student(all rows)
	public List<Student> getallStudent()
	{
		List<Student> student=this.hibernateTemplate.loadAll(Student.class);
		return student;		
	}
	// delete data
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class,studentId);	
		this.hibernateTemplate.delete(student);
	}
	// get update
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	
public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}
 
}
