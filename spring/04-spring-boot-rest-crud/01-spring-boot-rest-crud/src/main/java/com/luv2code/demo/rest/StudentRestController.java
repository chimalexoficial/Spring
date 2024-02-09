package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    //creating list of students
    private List<Student> theStudents;

    // define @PostConstruct to load student data, only once!
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        //creating student objects
        Student student1 = new Student("Poornima", "Patel");
        Student student2 = new Student("Mario", "Rossi");
        Student student3 = new Student("Mary", "Smith");

        //adding to list each object
        theStudents.add(student1);
        theStudents.add(student2);
        theStudents.add(student3);
    }
    //define endpoint for "/students" - list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    // define endpoint for student by Id /students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) { // same name
        return theStudents.get(studentId);
    }
}
