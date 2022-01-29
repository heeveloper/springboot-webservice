package com.heeveloper.webservice.controller.post;

import com.heeveloper.webservice.domains.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String createdAt;
    private String modifiedAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.content = post.getContent();
        this.createdAt = toStringDateTime(post.getCreatedAt());
        this.modifiedAt = toStringDateTime(post.getModifiedAt());
    }

    private String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
