package com.hoony.lab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoony.lab.dto.Student;
import com.hoony.lab.service.IStudentService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/api")
@RestController
public class MainController {
	
	@Autowired
	IStudentService studentService;
	
	@RequestMapping(value = "/Student", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudent() throws Exception {
		
		List<Student> list = new ArrayList<>();
		
		list = studentService.getStudent();
		
		if(list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/Student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentOne(@PathVariable int id) throws Exception {
		
		Student student = new Student();
		
		student = studentService.getStudentOne(id);
		
		if(student.getS_id() == 0) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/Student", method = RequestMethod.POST)
	public ResponseEntity<List<Student>> addStudent(@RequestBody Student student) throws Exception {
		
		studentService.addStudent(student);
		
		List<Student> list = new ArrayList<>();
		
		list = studentService.getStudent();
		
		if(list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/Student/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable int id) throws Exception {
		
		studentService.deleteStudent(id);
		
		List<Student> list = new ArrayList<>();
		
		list = studentService.getStudent();
		
		if(list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/Student", method = RequestMethod.PUT)
	public ResponseEntity<List<Student>> updateStudent(@RequestBody Student student) throws Exception {
			
		System.out.println(student.toString());
		
		studentService.updateStudent(student);
		
		List<Student> list = new ArrayList<>();
		
		list = studentService.getStudent();
		
		if(list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		}
	}

	

}


