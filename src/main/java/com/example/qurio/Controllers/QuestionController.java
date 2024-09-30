package com.example.qurio.Controllers;

import com.example.qurio.DTOS.QuestionDto;
import com.example.qurio.Models.Question;
import com.example.qurio.Models.QuestionDocument;
import com.example.qurio.Service.QuestionSearchService;
import com.example.qurio.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionSearchService questionSearchService;

    @GetMapping
    public List<Question>getallquestions(@RequestParam int page,@RequestParam int size){
        return  questionService.getallquestions(page, size);
    }

    @GetMapping("/{questionId}")

    public Optional<Question> getquestionbyId(@PathVariable Long questionId){
        Optional<Question> question=questionService.getquestionbyId(questionId);
        return question;
    }

    @PostMapping
     public Question createQuestion( @RequestBody QuestionDto questionDto){
        return questionService.createQuestion(questionDto);
    }
    @GetMapping("/search")
    public  List<QuestionDocument>searchQuestions(@RequestParam String query){
        return questionSearchService.searchQuestions(query);
    }
}
