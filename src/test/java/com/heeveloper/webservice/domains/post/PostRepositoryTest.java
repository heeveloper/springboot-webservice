package com.heeveloper.webservice.domains.post;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostRepositoryTest {
    
    @Autowired
    PostRepository postRepository;

    @Test
    public void 게시글저장_불러오기() {
        // given
        postRepository.save(Post.builder()
                .title("테스트 타이틀")
                .author("테스트 작가")
                .content("테스트 컨텐츠")
                .build()
        );

        // when
        List<Post> posts = postRepository.findAll();

        // then
        Post post = posts.get(0);
        assertThat(post.getTitle(), is("테스트 타이틀"));
        assertThat(post.getAuthor(), is("테스트 작가"));
        assertThat(post.getContent(), is("테스트 컨텐츠"));
    }
}
