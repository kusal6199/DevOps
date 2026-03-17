package com.example.CrudStudentApi.service;

import com.example.CrudStudentApi.entity.Student;
import com.example.CrudStudentApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void saveStudent(Student student){
        repository.save(student);
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }
}
