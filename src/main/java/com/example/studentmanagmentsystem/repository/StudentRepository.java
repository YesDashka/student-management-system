package com.example.studentmanagmentsystem.repository;

import com.example.studentmanagmentsystem.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {
    private static List<Student> students;
    private static long id = 0;

    public StudentRepository() {
        if(students == null) {
            students = new ArrayList<>();
            students.add(new Student(++id, "Daryna", "Yesypchuk", "daryna.yesypchuk@gmail.com"));
            students.add(new Student(++id, "Iryna", "Martynenko", "iryna.martynenko@gmail.com"));
            students.add(new Student(++id, "Kateryna", "Vaskevich", "kateryna.vaskevich@gmail.com"));
        }
    }

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findById(long id) {
        for (Student student: students) {
            if (student.getId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public boolean deleteById(long id) {
        Iterator<Student> i = students.iterator();
        while (i.hasNext()) {
            if (i.next().getId() == id) {
                i.remove();
                return true;
            }
        }
        return false;
    }

    public void save(Student student) {
        student.setId(++id);
        students.add(student);
    }
}
