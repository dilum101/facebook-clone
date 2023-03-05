package com.Dilum.FacebookClone.controller;

import com.Dilum.FacebookClone.model.PostModel;
import com.Dilum.FacebookClone.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post")
@CrossOrigin(value = "http://localhost:3000")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostModel addPost(@RequestParam Map<String,String> requestParams) throws Exception {
        String strPost = requestParams.get("post");
        String strEmail = requestParams.get("email");
        String strName = requestParams.get("name");
        String strFile = requestParams.get("file");
        String strProfilePic = requestParams.get("profilePic");

        PostModel post  = PostModel.builder()
                .post(strPost)
                .email(strEmail)
                .file(strFile)
                .profilePicture(strProfilePic)
                .timeStamp(new Date().toString())
                .build();


        post = postService.addPost(post);
        return post;
    }

    @GetMapping
    public List<PostModel> getPost()
    {
        return postService.getPost();
    }

}
