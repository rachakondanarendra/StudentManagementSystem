# Student Management System

This is a Dynamic Java EE project created using Eclipse IDE.  The project includes a simple web application that interacts with a MySQL database.  The database has a single table named 'students' within the 'student_db' database.


## Project Overview

This project is a basic web application designed to manage student records.  It demonstrates the use of Java EE technologies to create a dynamic web application that can perform CRUD (Create, Read, Update, Delete) operations on a MySQL database.
### Features
**Add Student:** Allows you to add a new student to the database.
**Update Student:** Enables updating the details of an existing student.
**Delete Student:** Permits deleting a student from the database.
**Display Students:** Displays a list of all students in the database.

## Technologies Used
Java EE
JSP (JavaServer Pages)
Servlets
MySQL
JDBC (Java Database Connectivity)
Eclipse IDE
Apache Tomcat (or any other compatible servlet container)

## Installation

**Clone the Repository:**
write this follwing command in command prompt.

**Example :** **C:\Users\NARENDRA>: git clone https://github.com/rachakondanarendra/StudentManagementSystem.git**

**Set up MySQL Database**

Create a database named 'student_db'.
Create a table named 'students' with the appropriate schema given below.

CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45),
  email VARCHAR(45),
  age INT
);

## Import the Project into Eclipse and Run:
Open Eclipse IDE.
File > Import > Existing Projects into Workspace > Select the cloned repository folder.
Configure Apache Tomcat in Eclipse.
Right-click the project > Run As > Run on Server > Select Tomcat server.
Open your web browser and navigate to http://localhost:8080/Student.
Use the provided buttons to add, update, delete, or display student records.

