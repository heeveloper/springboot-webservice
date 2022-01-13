package com.heeveloper.webservice.service;

import com.heeveloper.webservice.controller.post.AddPostRequestDto;
import com.heeveloper.webservice.domains.post.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository postRepository;

    public void add(AddPostRequestDto requst) {
        postRepository.save(requst.toEntity());
    }
}
