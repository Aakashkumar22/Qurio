package com.example.qurio.Service;

import com.example.qurio.Models.Question;
import com.example.qurio.Models.Tags;
import com.example.qurio.Models.User;
import com.example.qurio.Respository.QuestionRepository;
import com.example.qurio.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserFeedService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getUserFeed(Long userId, int page, int size) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Set<Long> tagIds = user.getFollwedTags().stream().map(Tags::getId).collect(Collectors.toSet());

        return questionRepository.findQuestionsByTags(tagIds, PageRequest.of(page, size)).getContent();
    }


}
