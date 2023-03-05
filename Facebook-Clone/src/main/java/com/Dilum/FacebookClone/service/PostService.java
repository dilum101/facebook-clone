package com.Dilum.FacebookClone.service;

import com.Dilum.FacebookClone.model.PostModel;

import java.util.List;

public interface PostService {
    PostModel addPost(PostModel post) throws Exception;

    List<PostModel> getPost();
}
