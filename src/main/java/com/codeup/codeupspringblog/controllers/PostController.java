package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repository.PostRepository;
import com.codeup.codeupspringblog.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;


    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String postsHome(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postsHome(@PathVariable long id, Model model){
        Post post = postDao.findPostById(id);
        model.addAttribute("post", post);
       return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postForm(){
        return "posts/create";
    }

    @PostMapping("/post/create")
    public String postCreate(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        User user = userDao.findUserById(1);
        Post post = new Post(title, body, user);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }


}
