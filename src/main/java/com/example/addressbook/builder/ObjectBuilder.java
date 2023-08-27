package com.example.addressbook.builder;


import com.example.addressbook.primaryEntity.Student;
import com.example.addressbook.primaryEntity.StudentDTO;
import com.example.addressbook.secondaryEntity.Teacher;
import com.example.addressbook.secondaryEntity.TeacherDTO;

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
