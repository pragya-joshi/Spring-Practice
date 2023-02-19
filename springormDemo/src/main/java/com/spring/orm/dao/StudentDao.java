package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.model.Student;

import javax.transaction.Transactional;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//Transactional
	
	//save, insert data
	@Transactional
	public int insert(Student student) {
		Integer i=(Integer) this.hibernateTemplate.save(student);
		return i;	
	}
	
	
//	fetch single row
	
	public Student getStudent(int studentId) {
		Student student= this.hibernateTemplate.get(Student.class,studentId);
		return student;	
	}
	
	
//	fetch all rows ->load all
	public List<Student> getAllStudents() {
		List<Student>student= this.hibernateTemplate.loadAll(Student.class);
		return student;	
	}
	
//	delete student
	@Transactional
	public void delete(int studentId) {
		Student student=this.getStudent(studentId);
		this.hibernateTemplate.delete(student);
	}
	
//	update student
	@Transactional
	public void update(Student student) {
		
		this.hibernateTemplate.update(student);
	}
	
}
