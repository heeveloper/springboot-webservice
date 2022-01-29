package com.heeveloper.webservice.service;

import com.heeveloper.webservice.controller.post.AddPostRequestDto;
import com.heeveloper.webservice.controller.post.PostResponseDto;
import com.heeveloper.webservice.domains.post.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository postRepository;

    @Transactional
    public void add(AddPostRequestDto requst) {
        postRepository.save(requst.toEntity());
    }

    // readOnly 옵션을 추가하면 트랜잭션 범위는 유지하되, 조회기능만 남겨두어 조회 속도가 개선된다.
    @Transactional(readOnly = true)
    public List<PostResponseDto> findAllDesc() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(PostResponseDto::new)  // .map(posts -> new PostsMainResponseDto(posts))
                .collect(Collectors.toList());
    }
}
