package com.example.addressbook.controller;


import com.example.addressbook.builder.ObjectBuilder;
import com.example.addressbook.entities.primary.Student;
import com.example.addressbook.entities.primary.StudentDTO;
import com.example.addressbook.repositories.primary.studentRepository;
import com.example.addressbook.entities.secondary.Teacher;
import com.example.addressbook.entities.secondary.TeacherDTO;
import com.example.addressbook.repositories.secondary.teacherRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentTeacherRestController {

	@Autowired
	@Qualifier("primaryEntityManagerFactory") // Specify the qualifier for the primary data source
	EntityManagerFactory primaryEntityManagerFactory;

	@Autowired
	@Qualifier("secondaryEntityManagerFactory") // Specify the qualifier for the secondary data source
	EntityManagerFactory secondaryEntityManagerFactory;

	@Autowired
	studentRepository studentRepo;

	@Autowired
	teacherRepository teacherRepo;

	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody StudentDTO studentDTO) {
		Student student = ObjectBuilder.createStudentFromStudentDTO(studentDTO);
		return studentRepo.save(student);
	}

	@PostMapping("/saveTeacher")
	public Teacher saveTeacher(@RequestBody TeacherDTO teacherDTO) {
		Teacher teacher = ObjectBuilder.createTeacherFromTeacherDTO(teacherDTO);
		return teacherRepo.save(teacher);
	}

//	@GetMapping("/getAllStudents")
//	public List<Student> getAllStudents(){
//		return studentRepo.findAll();
//	}
//
	@GetMapping("/getAllTeachers")
	public List<Teacher> getAllTeachers(){
		return teacherRepo.findAll();
	}
}
