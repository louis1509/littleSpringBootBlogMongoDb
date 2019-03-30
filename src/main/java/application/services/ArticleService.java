package application.services;

import application.domains.Article;
import application.input.ArticleInput;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


public interface ArticleService {

    public void saveArticle(ArticleInput articleInput) throws IOException;

    List<Article> getAllArticles();


}
