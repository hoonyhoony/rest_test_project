package com.hoony.lab.service;

import java.util.List;

import com.hoony.lab.dto.Student;

public interface IStudentService {
	
	List<Student> getStudent();

	void addStudent(Student student);

	void deleteStudent(int id);

	Student getStudentOne(int id);

	void updateStudent(Student student);

}
