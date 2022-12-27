package com.connecdb.jdbcpractice.controller;

import com.connecdb.jdbcpractice.entity.Student;
import com.connecdb.jdbcpractice.dao.StudentRowMapper;
import com.connecdb.jdbcpractice.service.StudentService;
import com.connecdb.jdbcpractice.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // #1
    // 透過 ID 搜尋單一學生
    @GetMapping("/students/{studentId}")
    public Student Select(@PathVariable Integer studentId) {
        return studentService.getById(studentId);
    }

    // #2
    // 搜尋全部學生
    @GetMapping("/students")
    public  List<Student> query() {
        return studentService.getAll();
    }

    // #3
    // 透過 POST Request 新增一筆學生資料 (預設 - id 自動新增)
    @PostMapping("/students")
    public String insert(@RequestBody Student student) {
        Student newStudent = new Student();
        newStudent.setName(student.getName());
        studentService.InsertStudent(newStudent);

        return "執行 INSERT sql";
    }

    // #4
    // 透過 POST Request 新增多筆學生資料
    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> studentList) {
        studentService.InsertStudents(studentList);
        return "Insert List Done !!";
    }

    // #5
    // 透過Delete Request 刪除單筆指定資料
    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        studentService.DeleteStudent(studentId);
        return "執行 DELETE sql";
    }
}
