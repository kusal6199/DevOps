package com.example.CrudStudentApi.service;

import com.example.CrudStudentApi.entity.Student;
import com.example.CrudStudentApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

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

    public void deleteStudentById(Long id){
        repository.deleteById(id);
    }

    public Student findStudentById(Long id){
        return repository.getStudentById(id);
    }

    public Long getStudentId(Student student) {
        return student.getId();
    }
}
