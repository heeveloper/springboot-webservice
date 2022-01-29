package com.heeveloper.webservice.service;

import com.heeveloper.webservice.controller.post.AddPostRequestDto;
import com.heeveloper.webservice.domains.post.Post;
import com.heeveloper.webservice.domains.post.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    public void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다 () {
        // given
        AddPostRequestDto dto = AddPostRequestDto.builder()
                .author("heeveloper")
                .content("테스트content")
                .title("테스트title")
                .build();

        // when
        postService.add(dto);

        // then
        Post post = postRepository.findAll().get(0);
        assertThat(post.getAuthor(), is("heeveloper"));
        assertThat(post.getContent(), is("테스트content"));
        assertThat(post.getTitle(), is("테스트title"));
    }
}
