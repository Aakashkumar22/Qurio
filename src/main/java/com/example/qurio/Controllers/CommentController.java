package com.example.qurio.Controllers;

import com.example.qurio.DTOS.CommentDto;
import com.example.qurio.Models.Comment;
import com.example.qurio.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("comments")
public class CommentController {
    @Autowired
    CommentService commentService;


    @GetMapping("/answer/{answerId}")
    public List<Comment> findByCommentAnswerId(@PathVariable Long answerId, @RequestParam int page, @RequestParam int size) {
        return commentService.findByCommentAnswerId(answerId, page, size);
    }

    @GetMapping("/comment/{commentId}")
    public List<Comment> findByParentcommentId(@PathVariable Long commentId, @RequestParam int page, @RequestParam int size) {
        return commentService.findByParentcommentId(commentId, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentByid(@PathVariable Long id) {
        Optional<Comment> comment = commentService.getCommentByid(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Comment createComment(@RequestBody CommentDto commentDTO) {
        return commentService.createComment(commentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
