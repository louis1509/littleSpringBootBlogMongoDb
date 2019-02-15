package application.controllers;

import application.input.ArticleInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ArticleController {


    @PostMapping("/article")
    ResponseEntity<?> saveArticle (@RequestBody ArticleInput articleInput){

    }

}
