package com.instagram.backend.controller;

import com.instagram.backend.model.User;
import com.instagram.backend.model.Post;
import com.instagram.backend.service.DataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*") // frontend separate
public class AppController {

    private final DataService dataService;

    public AppController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/signup")
    public Map<String, String> signup(@RequestBody User user) {
        for (User u : dataService.users) {
            if (u.email.equals(user.email)) {
                return Map.of("message", "User already exists");
            }
        }
        dataService.users.add(user);
    return Map.of("message", "Signup successful");
}


    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        for (User u : dataService.users) {
            if (u.email.equals(user.email) && u.password.equals(user.password)) {
                return Map.of("message", "Login successful", "success", true);
            }
        }
    return Map.of("message", "Invalid credentials", "success", false);
}


    @PostMapping("/posts")
    public String createPost(@RequestBody Post post) {
        dataService.posts.add(post);
        return "Post created";
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return dataService.posts;
    }
}
