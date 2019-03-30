package application.domains;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="article")
public class Article {

    @Id
    public ObjectId _id;

    private String photo;
    private String title;
    private String description;
    private String text;
    private String author_id;

    public Article() {
    }

    public Article(ArticleBuilder articleBuilder) {

        this.photo = articleBuilder.photo;
        this.title = articleBuilder.title;
        this.description = articleBuilder.description;
        this.text = articleBuilder.text;
        this.author_id = articleBuilder.author_id;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public static class ArticleBuilder{
        private String photo;
        private String title;
        private String description;
        private String text;
        private String author_id;

        public ArticleBuilder photo(String photo){
            this.photo = photo;
            return this;
        }
        public ArticleBuilder title(String title){
            this.title = title;
            return this;
        }
        public ArticleBuilder description(String description){
            this.description = description;
            return this;
        }
        public ArticleBuilder text(String text){
            this.text = text;
            return this;
        }
        public ArticleBuilder author_id(String author_id){
            this.author_id = author_id;
            return this;
        }

        public Article build() {
            return new Article(this);
        }
    }

}
