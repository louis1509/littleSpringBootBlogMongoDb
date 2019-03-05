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

    public Article(ObjectId _id, String photo, String title, String description, String text, String author_id) {
        this._id = _id;
        this.photo = photo;
        this.title = title;
        this.description = description;
        this.text = text;
        this.author_id = author_id;
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
}
