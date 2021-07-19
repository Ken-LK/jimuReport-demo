package com.bestway.jimu.controller;

import com.alibaba.fastjson.JSONObject;
import com.bestway.jimu.dto.StudentDTO;
import com.bestway.jimu.vo.StudentVO;
import com.github.jsonzou.jmockdata.JMockData;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/student")
public class StudentController {


   private List<StudentVO> studentVOList;

    @PostMapping("list")
    public JSONObject list(StudentDTO studentDTO) {



        if (CollectionUtils.isEmpty(studentVOList)){
            studentVOList = buildStudentList();
        }

        JSONObject jsonObject = new JSONObject();

        String age = studentDTO.getAge();

        String education = studentDTO.getEducation();

        if (StringUtils.hasText(age) || StringUtils.hasText(education)) {
            List<StudentVO> list = studentVOList.stream().filter(studentVO ->
                    age.equals(studentVO.getAge()) || education.equals(studentVO.getEducation())
            ).collect(Collectors.toList());
            jsonObject.put("data", list);
        }else {
            jsonObject.put("data", studentVOList);
        }

        return jsonObject;
    }


    private List<StudentVO> buildStudentList() {

        StudentVO studentVO;
        studentVOList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            studentVO = StudentVO.builder()
                    .department(JMockData.mock(String.class))
                    .age(JMockData.mock(Integer.class).toString())
                    .education(JMockData.mock(String.class))
                    .sex(JMockData.mock(String.class))
                    .name(JMockData.mock(String.class))
                    .build();



            studentVOList.add(studentVO);

        }


        return studentVOList;

    }


}
