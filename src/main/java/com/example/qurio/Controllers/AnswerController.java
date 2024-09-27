package com.example.qurio.Controllers;

import com.example.qurio.DTOS.AnswerDto;
import com.example.qurio.Models.Answer;
import com.example.qurio.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;
    @GetMapping("/question/{questionId}")
    public List<Answer>findByQuestionId(@PathVariable Long questionId, @RequestParam int page, @RequestParam int size) {
        return answerService.findByQuestionId(questionId, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Optional<Answer> answer = answerService.getAnswerById(id);
        return answer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Answer createAnswer(@RequestBody AnswerDto answerDTO) {
        return answerService.createAnswer(answerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
