package com.example.CrudStudentApi.repository;

import com.example.CrudStudentApi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

}