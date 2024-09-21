package com.example.qurio.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Tags  extends  BaseModel{
    private String name;
    @ManyToMany(mappedBy ="follwedTags")
    private Set<User> followers;

}
