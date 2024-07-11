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

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/addStudent")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        
        Student student = new Student(name, email, age);
        
        StudentDAOImp ob = new StudentDAOImp();
        
        Boolean isAdded = ob.addStudent(student);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alert Example</title>");
        out.println("</head>");
        out.println("<body>");
        
        if(isAdded) {
            // JavaScript alert and redirect for success
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Student details added successfully');");
            out.println("window.location.href = 'addStudent.html';");  // Redirect to success.html
            out.println("</script>");
        } else {
            // JavaScript alert and redirect for failure
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Failed to add Student details');");
            out.println("window.location.href = 'addStudent.html';");  // Redirect to failure.html
            out.println("</script>");
        }
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}
