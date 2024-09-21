package com.example.qurio.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class User extends  BaseModel{
    private Long id;
    private String password;

    @ManyToMany
    @JoinTable(name ="User_tags",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns =@JoinColumn (name="tag_id"))

    private Set<Tags> follwedTags;


}
