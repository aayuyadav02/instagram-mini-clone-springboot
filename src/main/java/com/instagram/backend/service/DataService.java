package com.instagram.backend.service;

import com.instagram.backend.model.User;
import com.instagram.backend.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    public List<User> users = new ArrayList<>();
    public List<Post> posts = new ArrayList<>();
}
