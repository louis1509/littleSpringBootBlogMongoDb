package application.services;

import application.domains.Article;
import application.input.ArticleInput;
import application.repositories.ArticleRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void saveArticle(ArticleInput articleInput) throws IOException{
        byte[] data = Base64.decodeBase64(articleInput.getBase64photo());
        OutputStream stream = new FileOutputStream("images/" + articleInput.getArticle().get_id().toString() + ".jpeg");
        stream.write(data);
        articleRepository.save(articleInput.getArticle());
    }

    @Override
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }




}
