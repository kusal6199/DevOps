package com.example.CrudStudentApi.controller;

import com.example.CrudStudentApi.entity.Student;
import com.example.CrudStudentApi.repository.StudentRepository;
import com.example.CrudStudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    private ResponseEntity<Student> createStudent(@RequestBody Student student){
        service.saveStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletStudent(@PathVariable Long id){
        service.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        Student oldStudent = service.findStudentById(student.getId());
        if (oldStudent != null){
            if (student.getAddress()!=null){
                oldStudent.setAddress(student.getAddress());
            }

            if (student.getEmail()!=null)
                oldStudent.setEmail(student.getEmail());

            if (student.getFullName()!=null)
                oldStudent.setFullName(student.getFullName());

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
