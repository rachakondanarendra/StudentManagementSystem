package com.student.DAOImp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.DAO.StudentDAO;
import com.student.model.Student;

public class StudentDAOImp implements StudentDAO{
	Connection connection = null;
	
	public StudentDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}	}


	@Override
	public Boolean addStudent(Student s) {
		
		String sql = "INSERT INTO STUDENTS(name,email,age) VALUES(?,?,?)";
		
		PreparedStatement pstmt = null;
		 try {
			 
			    pstmt = connection.prepareStatement(sql);
		        
		        pstmt.setString(1, s.getName());
		        pstmt.setString(2, s.getEmail());
		        pstmt.setInt(3, s.getAge());
		        int n = pstmt.executeUpdate();
		        if(n==1)
		        {
		        	return true;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 
		 return false;

		
	}

	@Override
	public Boolean updateStudent(Student s) {
		String sql = "UPDATE STUDENTS SET name = ?, email = ?, age = ? WHERE id = ?";
		
		PreparedStatement pstmt = null;
        try {
        	
        	pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, s.getName());
            pstmt.setString(2, s.getEmail());
            pstmt.setInt(3, s.getAge());
            pstmt.setInt(4, s.getId());
            int n = pstmt.executeUpdate();
            
            if(n==1)
            {
            	return true;
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
        return false;
		
	}

	@Override
	public Boolean deleteStudent(int id) {
		
		String sql = "DELETE FROM STUDENTS WHERE id = ?";
		
		PreparedStatement pstmt = null;
        try {
        	
        	pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            int n = pstmt.executeUpdate();
            if(n==1)
            {
            	return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;		
	}

	@Override
	public List<Student> displayAllStudents() {
		
		
		String sql = "SELECT * FROM STUDENTS";
        List<Student> students = new ArrayList<>();
        
        Statement stmt = null;
        try {
        	
        	stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        	
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                Student student = new Student(id, name, email, age);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
		
		
	}
	

}
