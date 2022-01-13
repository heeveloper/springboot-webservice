package com.heeveloper.webservice.controller.post;

import com.heeveloper.webservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping("post")
    public void add(@RequestBody AddPostRequestDto request) {
        postService.add(request);
    }
}
