package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    boolean deleteStudentById(long id);
    Student getStudentById(long id);
    Student saveStudent(Student student);


}
