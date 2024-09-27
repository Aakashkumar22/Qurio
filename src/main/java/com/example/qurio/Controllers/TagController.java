package com.example.qurio.Controllers;

import com.example.qurio.DTOS.TagDto;
import com.example.qurio.Models.Tags;
import com.example.qurio.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tags")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping
    public List<Tags>getalltags(){
        return tagService.getalltags();
    }

    @PostMapping
    public Tags createtag(@RequestBody TagDto tagDto){
        return tagService.createtag(tagDto);
    }

    @GetMapping("/{tagId}")
    public Optional<Tags> getTagById(@PathVariable("tagId") Long  tagId){
        return tagService.getTagById(tagId);
    }


}
