package com.connecdb.jdbcpractice.dao;

import com.connecdb.jdbcpractice.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    //1.
    @Override
    public Student getById(Integer studentId) {
        String sql = "SELECT id,name FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId" , studentId);

        List<Student> list = namedParameterJdbcTemplate.query(sql,map,new StudentRowMapper());

        //返回
        if (list.size() > 0 ) {
            return list.get(0);
        } else {
            return null;
        }
    }

    //2.
    @Override
    public List<Student> getAll() {
        String sql = "SELECT id,name FROM student";
        Map<String, Object> map = new HashMap<>();

        List<Student> list = namedParameterJdbcTemplate.query(sql,map,new StudentRowMapper());
        return list;
    }

    //3.
    @Override
    public  Student InsertStudent(Student student) {
        //加上 ":" 後， RequestBody Student student -> map -> sql :studentName
        String sql = "INSERT INTO student(name) VALUE (:studentName)";

        //Request值透過map來處理
        Map<String, Object> map = new HashMap<>();
        map.put("studentName" , student.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        //(sql語法, map模板)
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        return null;
    }

    //4.


    @Override
    public List<Student> InsertStudents(List<Student> students) {
        String sql = "INSERT INTO student (name) VALUE (:studentName)";

        //根據 students size 產生相同長度的 parameterSources
        //在對應位置產生一個 MapSqlParameterSource() 物件

        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[students.size()];
        for (int i = 0 ; i < students.size() ; i++) {
            Student student = students.get(i);
            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName" , student.getName());
        }

        namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);
        return null;
    }

    @Override
    public Student deleteAstudent(Integer studentId) {
        String sql = "DELETE FROM student WHERE id = :studentId";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId" , studentId);

        namedParameterJdbcTemplate.update(sql,map);
        return null;
    }
}
