package com.example.qurio.Service;

import com.example.qurio.DTOS.TagDto;
import com.example.qurio.Models.Tags;
import com.example.qurio.Respository.TagsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private TagsRepository tagsRepository;

     public TagService(TagsRepository tagsRepository){
         this.tagsRepository=tagsRepository;

     }

    public List<Tags>getalltags(){
        return tagsRepository.findAll();
    }

    public Tags createtag(TagDto tagDto){
        Tags tag=new Tags();
        tag.setName(tagDto.getTagname());
        return tagsRepository.save(tag);
    }

    public Optional<Tags> getTagById(Long id){
        return tagsRepository.findById(id);
    }
}
