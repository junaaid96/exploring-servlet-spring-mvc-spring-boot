package org.example.springjdbch2;

import org.example.springjdbch2.model.Student;
import org.example.springjdbch2.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbch2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbch2Application.class, args);

        Student student = context.getBean(Student.class);
        student.setRollNo(201);
        student.setName("Kabir");
        student.setMarks(90);

        System.out.println(student.toString());

        StudentService studentService = context.getBean(StudentService.class);
        studentService.addStudent(student);

        List<Student> students = studentService.getStudents();
        System.out.println(students);
    }

}
