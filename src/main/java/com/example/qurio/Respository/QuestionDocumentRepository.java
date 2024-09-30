package com.example.qurio.Respository;

import com.example.qurio.Models.QuestionDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDocumentRepository extends ElasticsearchRepository<QuestionDocument,String> {
    List<QuestionDocument>findByTitleOrContextContaining(String title,String context);
}


