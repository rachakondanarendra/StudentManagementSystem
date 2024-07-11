package com.student.controller;

import com.student.DAOImp.StudentDAOImp;
import com.student.model.Student;

public class Main {

	public static void main(String[] args) {
		
		Student s = new Student("Henry", "henry@gmail.com", 20);	
		
		StudentDAOImp ob = new StudentDAOImp();
		
		ob.addStudent(s);
	}

}
