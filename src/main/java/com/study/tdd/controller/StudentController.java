package com.study.tdd.controller;

import com.study.tdd.dto.ReqStudentAddStudent;
import com.study.tdd.dto.RespSaveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody ReqStudentAddStudent dto) {
        RespSaveDto respSaveDto = new RespSaveDto(true, "학생 추가 완료");
        return ResponseEntity.ok().body(respSaveDto);
    }
}
