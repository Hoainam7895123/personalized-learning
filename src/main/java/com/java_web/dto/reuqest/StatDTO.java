package com.java_web.dto.reuqest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatDTO {
    int id;
    String name;
    float score;
    int total;
}

