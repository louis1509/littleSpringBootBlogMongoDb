package application.controllers;

import application.domains.Article;
import application.input.ArticleInput;
import application.repositories.ArticleRepository;
import application.services.ArticleService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {


    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }


    @PutMapping("/article/{id}")
    ResponseEntity<?> saveArticle (@Valid @RequestBody ArticleInput articleInput){
        try {
            articleService.saveArticle(articleInput);
            return  ResponseEntity.ok().body(articleInput);
        } catch (IOException e) {
           return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @PostMapping("/article")
    ResponseEntity<?> createArticle(@Valid @RequestBody String articleInput){
       /* try {
            articleInput.getArticle().set_id(ObjectId.get());
            articleService.saveArticle(articleInput);
            return  ResponseEntity.ok().body(articleInput);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }*/
       System.out.println("Post Article : " + articleInput);
       return ResponseEntity.ok().body("yahouuuu");
    }



}
