package com.study.tdd.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.tdd.dto.ReqStudentAddStudent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 컨트롤러 테스트
@WebMvcTest(controllers = StudentController.class)
class StudentMapperControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void addStudent() throws Exception {
        ReqStudentAddStudent dto = new ReqStudentAddStudent();
        dto.setName("김준일");
        dto.setAge(10);
        ObjectMapper objectMapper = new ObjectMapper(); // 스프링 내에서 제이슨으로 바꿔ㅏ주는거
        String reqJsonBody = objectMapper.writeValueAsString(dto); // 객체를 넣어주면 제이슨 스트링으,로 바꿔줌

        mockMvc.perform(post("/student")
                        .contentType(MediaType.APPLICATION_JSON)  // 제이슨으로 들어올 거니까 제이슨을 받음
                        .content(reqJsonBody)
                )
                .andExpect(status().isOk()) // or isBadStatus() 혹은 오류코드를 직접 넣어줘도 됨
                .andExpect(jsonPath("$.isSaveSuccess").value(true)) // 응답에 대한 결과 확인 가능
                        .andExpect(jsonPath("$.message").value("학생 추가 완료")) // 응답에 대한 결과 확인 가능
                                .andDo(print());
    }
}