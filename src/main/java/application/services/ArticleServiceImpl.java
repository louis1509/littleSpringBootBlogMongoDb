package application.services;

import application.domains.Article;
import application.input.ArticleInput;
import application.repositories.ArticleRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Value("${images.location}")
    private String imagesLocation;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void saveArticle(ArticleInput articleInput) throws IOException{
        if(this.getFile(articleInput).isPresent()){
            String allEncodedData = articleInput.getBase64photo();
            String extension = "." + allEncodedData.substring("data:image/".length(), allEncodedData.indexOf(";base64"));
            String encodedImage = allEncodedData.split(",")[1];
            byte[] data = Base64.decodeBase64(encodedImage);
            OutputStream stream = new FileOutputStream(imagesLocation + articleInput.getArticle().get_id().toString() + extension);
            stream.write(data);
            //set path of illustration
            articleInput.getArticle().setPhoto("/images/" + articleInput.getArticle().get_id().toString() + extension);

            

        }


        articleRepository.save(articleInput.getArticle());

    }

    @Override
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }



    public Optional<String> getFile(ArticleInput articleInput){
        return Optional.ofNullable(articleInput.getBase64photo());
    }




}
