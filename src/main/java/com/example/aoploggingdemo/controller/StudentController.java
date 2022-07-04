package com.example.aoploggingdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aoploggingdemo.entity.StudentEntity;
import com.example.aoploggingdemo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/")
	public List<StudentEntity> getStudents(){
		return studentService.getStudents();
	}
	
	@PostMapping("/add")
	public StudentEntity addStudent(@RequestBody StudentEntity student){
		return studentService.addStudent(student);
	}
}
