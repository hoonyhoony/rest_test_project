package com.hoony.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoony.lab.dao.StudentDAO;
import com.hoony.lab.dto.Student;

@Service
public class StudentService implements IStudentService{
	
	@Autowired
	private StudentDAO dao;

	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return dao.getStudent();
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		dao.addStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		dao.deleteStudent(id);
	}

	@Override
	public Student getStudentOne(int id) {
		// TODO Auto-generated method stub
		return dao.getStudentOne(id);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		dao.updateStudent(student);
	}
	
	

}
