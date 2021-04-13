package com.demo.Servlet;

import com.demo.Dao.StudentDao;
import com.demo.Entity.StudentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = {"/"})
public class HomeServlet extends HttpServlet {
    StudentDao dao = new StudentDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StudentEntity> students = getAllStudents();
        if (students.isEmpty()) {
            insertStudents();
            students = getAllStudents();
        }
        request.setAttribute("students", students);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private List<StudentEntity> getAllStudents() {
        return dao.getStudents();
    }

    private void insertStudents() {
        for (int i = 1; i <= 5; i++) {
            StudentEntity student = new StudentEntity("Student " + i, 1, 18 + i, "0934251234", "So " + i + " Ton That Thuyet");
            dao.insertStudent(student);
        }
        for (int i = 6; i <= 10; i++) {
            StudentEntity student = new StudentEntity("Student " + i, 2, 18 + i, "0934251234", "So " + i + " Ton That Thuyet");
            dao.insertStudent(student);
        }
    }
}
