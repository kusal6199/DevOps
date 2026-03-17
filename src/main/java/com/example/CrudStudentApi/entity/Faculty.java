package com.example.CrudStudentApi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String department;

    @OneToMany(mappedBy = "faculty")
    private List<Course> courses;
}
