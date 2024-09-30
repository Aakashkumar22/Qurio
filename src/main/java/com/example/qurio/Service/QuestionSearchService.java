package com.example.qurio.Service;

import com.example.qurio.Models.QuestionDocument;
import com.example.qurio.Respository.QuestionDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionSearchService {
    @Autowired
    QuestionDocumentRepository questionDocumentRepository;
    public List<QuestionDocument>searchQuestions(String query){
        return questionDocumentRepository.findByTitleOrContextContaining(query,query);
    }
}
