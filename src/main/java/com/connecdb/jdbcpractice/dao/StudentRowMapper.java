package com.connecdb.jdbcpractice.dao;

import com.connecdb.jdbcpractice.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    //將來自SQL資料轉換成Java Obj
    //ResultSet rs = from sql data , 要注意String sql
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));

        return student;
    }
}
