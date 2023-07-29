package com.example.studentmanagmentsystem.service;

import com.example.studentmanagmentsystem.models.Student;
import com.example.studentmanagmentsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository repository) {
        this.studentRepository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public boolean deleteStudentById(long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        if(existingStudent != null) {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
            studentRepository.save(existingStudent);
        }
    }
}
