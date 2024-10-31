package com.study.tdd.repository;

import com.study.tdd.entity.Student;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
// 실제 데이터베이스에 영향을 주지 않겠다 - 테스트 데이터베이스를 따로 쓴다
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// 테스트가 실행되기 전에 SQL을 실행해라
@Sql(scripts = "/student_schema.sql")
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void save() {
        Student student = new Student(1L, "김준일", 31);
        int result = studentMapper.save(student);
        assertThat(result).isEqualTo(1);
    }
}