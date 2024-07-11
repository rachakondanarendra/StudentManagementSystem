package com.student.DAO;

import java.util.List;

import com.student.model.Student;

public interface StudentDAO {
	
	
	Boolean addStudent(Student s);
	Boolean updateStudent(Student s);	
	Boolean deleteStudent(int id);
	List<Student> displayAllStudents();
	



}
