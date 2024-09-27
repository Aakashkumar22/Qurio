package com.example.qurio.Service;

import com.example.qurio.DTOS.CommentDto;
import com.example.qurio.Models.Answer;
import com.example.qurio.Models.Comment;
import com.example.qurio.Respository.AnswerRepository;
import com.example.qurio.Respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.repository.util.ClassUtils.ifPresent;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    AnswerRepository answerRepository;

    public List<Comment>findByCommentAnswerId(Long  ansid,int page,int size){
        return commentRepository.findByCommentAnswerId(ansid, PageRequest.of(page,size)).getContent();
    }

    public Optional<Comment>getCommentByid(Long id){
        return commentRepository.findById(id);
    }

    public List<Comment>getallcomments(){
        return commentRepository.findAll();
    }
    public List<Comment>findByParentcommentId(Long parentCommentId,int page,int size){
        return commentRepository.findByCommentAnswerId(parentCommentId, PageRequest.of(page,size)).getContent();
    }

    public Comment createComment(CommentDto commentDto){
        Comment comment=new Comment();
        comment.setContext(comment.getContext());

        Optional<Answer> answer=answerRepository.findById(commentDto.getAnswerId());
        answer.ifPresent(comment::setCommentAnswer);
        return commentRepository.save(comment);

    }

    public void  deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }


}
