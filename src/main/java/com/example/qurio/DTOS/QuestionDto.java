package com.example.qurio.DTOS;

import lombok.Data;

import java.util.Set;

@Data
public class QuestionDto {
    private Long id;
    private String title;
    private String context;
    private Long userId;
    private Set<Long>tagIds;
}
