package org.example.springdatajpa;

import org.example.springdatajpa.model.Student;
import org.example.springdatajpa.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

        StudentRepository studentRepository = context.getBean(StudentRepository.class);

        Student student1 = context.getBean(Student.class);
        Student student2 = context.getBean(Student.class);
        Student student3 = context.getBean(Student.class);

        student1.setRollNo(1);
        student1.setName("John");
        student1.setMarks(90);

        student2.setRollNo(2);
        student2.setName("Jane");
        student2.setMarks(80);

        student3.setRollNo(3);
        student3.setName("Doe");
        student3.setMarks(70);

        // .save() -> insert and update
//        studentRepository.save(student1);
//        studentRepository.save(student2);
//        studentRepository.save(student3);

        studentRepository.delete(student2);

//        Optional<Student> s = studentRepository.findById(1);

        //if student with given rollNo is not present in the database, then print a new Student object with null values
//        System.out.println(s.orElse(new Student()));

//        System.out.println(studentRepository.findAll());
    }
}
