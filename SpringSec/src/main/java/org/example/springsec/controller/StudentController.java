package org.example.springsec.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.springsec.model.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "John", "Java"),
            new Student(2, "Jane", "Python"),
            new Student(3, "Doe", "C++")
    ));

    @GetMapping("/csrf")
    public CsrfToken getCrsfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}
