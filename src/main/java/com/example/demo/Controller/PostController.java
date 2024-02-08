package com.example.demo.Controller;

import com.example.demo.Service.PostService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/post")
public class PostController {
    @Autowired
    PostService postService;

    public String addPost (int userId,String content,String time){
        return postService.addPost(userId,content,time);
    }

    public String likePost (int postId){
        return postService.likePost(postId);
    }

}
