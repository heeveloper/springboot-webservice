package com.heeveloper.webservice.controller.post;

import com.heeveloper.webservice.domains.post.Post;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPostRequestDto {
    private String title;
    private String author;
    private String content;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();
    }
}
