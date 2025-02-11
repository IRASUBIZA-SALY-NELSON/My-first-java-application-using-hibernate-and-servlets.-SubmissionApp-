package com.app.submission.submissionapp.controllers;
import com.app.submission.submissionapp.services.StudentService;
import com.app.submission.submissionapp.models.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StudentRegistration extends HttpServlet {
    StudentService service = StudentService.getInstance();
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("WEB-INF/form.jsp").forward(request, response);
    }

    public StudentRegistration() {
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = "2005-02-20";
        LocalDate dob = LocalDate.parse(date, pattern);
        Student student = new Student(fname, lname, email, 12, dob);
        service.addStudent(student);
        request.setAttribute("message", "Added Successfully");
        List<Student> students = service.getAllStudents();
        request.setAttribute("students", students);
        doGet(request, response);
    }

    public void destroy() {
    }
}