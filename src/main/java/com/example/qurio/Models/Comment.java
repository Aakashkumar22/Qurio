package com.example.qurio.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Comment extends  BaseModel{
    private String context;

    @ManyToOne
    @JoinColumn(name="answer_id")
    private Answer commentAnswer;

    @ManyToOne
    @JoinColumn(name="parentcomment_id")
    private Comment parentcomment;

    @OneToMany(mappedBy ="parentcomment" )
    private Set<Comment>replies;

    @ManyToMany
    @JoinTable(name ="comment_like",joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns =@JoinColumn (name="user_id"))
    private Set<User> commentLikedUsers;

}
