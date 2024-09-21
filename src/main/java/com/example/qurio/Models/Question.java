package com.example.qurio.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Question extends  BaseModel{
    private String title;
    private String context;
    @ManyToMany
    @JoinTable(name ="Question_tags",joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns =@JoinColumn (name="tag_id"))
    private Set<Tags> questiontags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
