package com.connecdb.jdbcpractice.service;

import com.connecdb.jdbcpractice.dao.StudentDao;
import com.connecdb.jdbcpractice.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;

    // #1
    @Override
    public Student getById(Integer studentId) {
        return studentDao.getById(studentId);
    }

    // #2
    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    // #3
    @Transactional
    @Override
    public Student InsertStudent(Student newStudent) {
        return studentDao.InsertStudent(newStudent);
    }

    // #4
    @Transactional
    @Override
    public List<Student> InsertStudents(List<Student> studentList) {
        return studentDao.InsertStudents(studentList);
    }

    // #5

    @Transactional
    @Override
    public Student DeleteStudent(Integer studentId) {
        return studentDao.deleteAstudent(studentId);
    }
}
