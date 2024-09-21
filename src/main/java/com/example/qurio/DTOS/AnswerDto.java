package com.example.qurio.DTOS;

import lombok.Data;

@Data
public class AnswerDto {
    private  Long id;
    private  String context;
    private Long UserId;
    private Long questionId;
}
