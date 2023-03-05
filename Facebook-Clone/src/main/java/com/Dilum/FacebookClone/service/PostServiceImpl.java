package com.Dilum.FacebookClone.service;

import com.Dilum.FacebookClone.entity.PostEntity;
import com.Dilum.FacebookClone.model.PostModel;
import com.Dilum.FacebookClone.repository.PostEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{


    private PostEntityRepository postEntityRepository;

    public PostServiceImpl(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }


    @Override
    public PostModel addPost(PostModel post) throws Exception {

        try
        {
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post,postEntity);

            if(post.getFile() != null && !post.getFile().equalsIgnoreCase("null"))
            {
                postEntity.setImage(post.getFile());
            }
            else {
                postEntity.setImage(null);
            }

            postEntity = postEntityRepository.save(postEntity);
            post.setId(postEntity.getId());
            post.setFile(null);
            post.setImage(postEntity.getImage());
        }
        catch(Exception ex)
        {
            throw new Exception("Could not save post "+ ex);
        }
        return post;
    }

    @Override
    public List<PostModel> getPost() {

        List<PostEntity> postEntityList = postEntityRepository.findAll();
        List<PostModel> postModels = new ArrayList<>();
        postModels = postEntityList.stream().map((postEntity) ->
            PostModel.builder()
                    .id(postEntity.getId())
                    .timeStamp(postEntity.getTimeStamp())
                    .email(postEntity.getEmail())
                    .name(postEntity.getName())
                    .post(postEntity.getPost())
                    .image(postEntity.getImage())
                    .profilePicture(postEntity.getProfilePicture())
                    .build()

        ).collect(Collectors.toList());

        return postModels;
    }
}
