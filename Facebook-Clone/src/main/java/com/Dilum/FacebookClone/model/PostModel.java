package com.Dilum.FacebookClone.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {


    private String id;


    private String post;
    private String name;
    private String email;


    private String image;
    private String profilePicture;
    private String timeStamp;

    private String file;
}
