package application.repositories;

import application.domains.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository  extends MongoRepository<Article, String> {
        public Article save(Article article);

}
