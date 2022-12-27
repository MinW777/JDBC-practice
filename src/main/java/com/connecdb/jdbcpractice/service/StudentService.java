package com.connecdb.jdbcpractice.service;

import com.connecdb.jdbcpractice.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    Student getById(Integer studentId);

    List<Student> getAll();

    Student InsertStudent(Student newStudent);

    List<Student> InsertStudents(List<Student> studentList);

    Student DeleteStudent(Integer studentId);
}
