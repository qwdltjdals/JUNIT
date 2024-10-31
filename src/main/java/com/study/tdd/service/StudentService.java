package com.study.tdd.service;

import com.study.tdd.dto.RespSaveDto;
import com.study.tdd.repository.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;


}
