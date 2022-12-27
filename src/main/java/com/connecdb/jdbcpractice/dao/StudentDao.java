package com.connecdb.jdbcpractice.dao;

import com.connecdb.jdbcpractice.entity.Student;

import java.util.List;

public interface StudentDao {
        Student getById(Integer studentId);

        List<Student> getAll();

        Student InsertStudent(Student student);

        List<Student> InsertStudents(List<Student> students);

        Student deleteAstudent(Integer studentId);
}

