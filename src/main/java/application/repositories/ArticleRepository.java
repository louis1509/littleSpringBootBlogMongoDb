package application.repositories;

import application.domains.Article;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository  extends MongoRepository<Article, String> {
        public Article save(Article article);
        public Article findBy_id(ObjectId id);

}
