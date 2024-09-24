package com.example.qurio.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Answer  extends  BaseModel{
    private  String context;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "commentAnswer")
    private Set<Comment> answerComments;


    @ManyToMany
    @JoinTable(name ="answer_like",joinColumns = @JoinColumn(name = "answer_id"),
            inverseJoinColumns =@JoinColumn (name="user_id"))
    private Set<User>answerLikedUser;



}
