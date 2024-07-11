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

@WebServlet("/deleteStudent")
public class DeleteServlet extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		int id = Integer.parseInt(request.getParameter("id"));
		
      
		StudentDAOImp ob = new StudentDAOImp();
		
		Boolean isDeleted = ob.deleteStudent(id);
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Alert Example</title>");
        out.println("</head>");
        out.println("<body>");
        
        if(isDeleted) {
            // JavaScript alert and redirect for success
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Student details deleted successfully');");
            out.println("window.location.href = 'deleteStudent.html';");  // Redirect to success.html
            out.println("</script>");
        } else {
            // JavaScript alert and redirect for failure
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Failed to delete student details because student id is not exist');");
            out.println("window.location.href = 'deleteStudent.html';");  // Redirect to failure.html
            out.println("</script>");
        }
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();

	}

}

