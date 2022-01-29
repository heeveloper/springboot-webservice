package com.heeveloper.webservice.controller.web;

import com.heeveloper.webservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostService postService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("post", postService.findAllDesc());
        // prefix: src/main/resources/templates, suffix: .hbs
        // src/main/resources/templates/main.hbs로 전환되어 View Resolver가 처리
        return "main";
    }
}
