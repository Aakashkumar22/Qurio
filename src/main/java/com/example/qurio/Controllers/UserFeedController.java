package com.example.qurio.Controllers;

import com.example.qurio.Models.Question;
import com.example.qurio.Service.UserFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("User/feed")
public class UserFeedController {
    @Autowired
    private UserFeedService userFeedService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Question>> getUserFeed(@PathVariable Long userId, @RequestParam int page, @RequestParam int size) {
        List<Question> feed = userFeedService.getUserFeed(userId, page, size);
        return ResponseEntity.ok(feed);
    }
}
