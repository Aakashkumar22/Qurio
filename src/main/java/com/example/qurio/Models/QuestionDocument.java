package com.example.qurio.Models;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "questions")
public class QuestionDocument {
    @Id
    private String  id;
    private String title;
    private String context;
    private Long userId;
}
