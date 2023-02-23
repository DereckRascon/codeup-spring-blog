package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {


    @GetMapping("/posts")
    public String postsHome(Model model){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1,"Test Post 1","This is test post 1."));
        posts.add(new Post(2,"Test Post 2","This is test post 2."));
        posts.add(new Post(3,"Test Post 3", "This is test post 3."));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsHome(@PathVariable long id, Model model){
        Post post = new Post(id, "Test Post 4", "This is test post 4.");
        model.addAttribute("post", post);
       return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postForm(){
        return "View the form for creating a post";
    }

    @PostMapping("/post/create")
    public void postCreate(){
//        Something happens here to store a post for later
    }


}
