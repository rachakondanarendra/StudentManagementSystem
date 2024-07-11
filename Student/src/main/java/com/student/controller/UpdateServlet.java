package com.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.DAOImp.StudentDAOImp;
import com.student.model.Student;


 
@WebServlet("/updateStudent")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
        Student student = new Student(id, name, email, age);
		
		StudentDAOImp ob = new StudentDAOImp();
		
		Boolean isUpdated = ob.updateStudent(student);
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alert Example</title>");
        out.println("</head>");
        out.println("<body>");
        
        if(isUpdated) {
            // JavaScript alert and redirect for success
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Student details updated successfully');");
            out.println("window.location.href = 'updateStudent.html';");  // Redirect to success.html
            out.println("</script>");
        } else {
            // JavaScript alert and redirect for failure
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Failed to add Student details because user id is not exist');");
            out.println("window.location.href = 'updateStudent.html';");  // Redirect to failure.html
            out.println("</script>");
        }
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();

	}

}
