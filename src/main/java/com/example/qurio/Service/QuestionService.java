package com.example.qurio.Service;

import com.example.qurio.DTOS.QuestionDto;
import com.example.qurio.Models.Question;
import com.example.qurio.Models.Tags;
import com.example.qurio.Models.User;
import com.example.qurio.Respository.QuestionRepository;
import com.example.qurio.Respository.TagsRepository;
import com.example.qurio.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TagsRepository tagsRepository;

    @Autowired
    QuestionIndexService questionIndexService;

    public Optional<Question> getquestionbyId(Long id){
        return questionRepository.findById(id);
    }

    public List<Question>getallquestions(int offset,int limit){
        return questionRepository.findAll(PageRequest.of(offset, limit)).getContent();
    }

        public Question createQuestion(QuestionDto questionDto) {
            Question question = new Question();
            question.setContext(questionDto.getContext());
            question.setTitle(questionDto.getTitle());
            question.setId(questionDto.getId());

            // Find user by ID
            Optional<User> user = userRepository.findById(questionDto.getUserId());
            user.ifPresent(question::setUser);

            // Convert tagIds to Tags objects
            Set<Tags> tags = questionDto.getTagIds().stream()
                    .map(tagsRepository::findById)
                    .filter(Optional::isPresent) // Keep only present Optionals
                    .map(Optional::get) // Get the Tags object from Optional
                    .collect(Collectors.toSet());

            question.setQuestiontags(tags);
            questionIndexService.indexService(question);

            return questionRepository.save(question);
        }


}
