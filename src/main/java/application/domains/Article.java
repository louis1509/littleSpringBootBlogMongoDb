package application.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="article")
public class Article {

    @Id
    private String id;

    private String photo;
    private String title;
    private String description;
    private String text;
    private String author_id;




}
