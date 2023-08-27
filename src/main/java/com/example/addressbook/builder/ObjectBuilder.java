package com.example.addressbook.builder;


import com.example.addressbook.entities.primary.Student;
import com.example.addressbook.entities.primary.StudentDTO;
import com.example.addressbook.entities.secondary.Teacher;
import com.example.addressbook.entities.secondary.TeacherDTO;

public class ObjectBuilder {
	
	
	public  static Student createStudentFromStudentDTO(StudentDTO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setSchoolName(studentDTO.getSchoolName());
		student.setStandard(studentDTO.getStandard());
		return student;
	}

	
	public static Teacher createTeacherFromTeacherDTO(TeacherDTO teacherDTO) {

		Teacher teacher = new Teacher();
		teacher.setName(teacherDTO.getName());
		teacher.setSubject(teacherDTO.getSubject());
		return teacher;
	}
}
