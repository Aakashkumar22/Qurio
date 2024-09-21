package com.example.qurio.DTOS;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String context;
    private Long AnswerId;
    private Long paremtcommentId;
}
