package com.EduSync.service;

import com.EduSync.entity.Student;
import com.EduSync.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student creteStudent(Student student){
        return studentRepository.save(student);
    }
}
