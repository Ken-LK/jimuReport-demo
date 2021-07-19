package com.bestway.jimu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentVO {

    @JsonProperty("department")
    private String department;
    @JsonProperty("education")
    private String education;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("age")
    private String age;
    @JsonProperty("name")
    private String name;
}
