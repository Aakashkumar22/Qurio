package com.example.qurio.Service;

import com.example.qurio.Models.Question;
import com.example.qurio.Models.QuestionDocument;
import com.example.qurio.Respository.QuestionDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionIndexService {
    @Autowired
    QuestionDocumentRepository questionDocumentRepository;

    public  void indexService(Question question){
        QuestionDocument questionDocument=new QuestionDocument();
        questionDocument.setId(question.getId().toString());
        questionDocument.setTitle(question.getTitle());
        questionDocument.setContext(question.getContext());
        questionDocument.setUserId(question.getUser().getId());
        questionDocumentRepository.save(questionDocument);
    }
}
