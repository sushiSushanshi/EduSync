package com.EduSync.controller;

import com.EduSync.entity.Student;
import com.EduSync.repository.StudentRepository;
import com.EduSync.service.StudentService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.creteStudent(student);
    }
}
