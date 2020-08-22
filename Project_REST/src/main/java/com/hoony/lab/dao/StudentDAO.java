package com.hoony.lab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hoony.lab.dto.Student;

@Repository
public class StudentDAO {
	
	@Autowired
	private SqlSession ss;
	
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return ss.selectList("hoony.student.getStudent");
	}

	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		ss.insert("hoony.student.addStudent", student);
	}

	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		ss.delete("hoony.student.deleteStudent", id);
	}

	public Student getStudentOne(int id) {
		// TODO Auto-generated method stub
		return ss.selectOne("hoony.student.getStudentOne", id);
	}

	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		ss.update("hoony.student.updateStudent", student);
	}

}
