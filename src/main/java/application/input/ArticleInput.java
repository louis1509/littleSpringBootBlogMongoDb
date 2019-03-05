package application.input;

import application.domains.Article;

import javax.validation.constraints.NotNull;

public class ArticleInput {

    @NotNull
    private Article article;

    private String base64photo;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getBase64photo() {
        return base64photo;
    }

    public void setBase64photo(String base64photo) {
        this.base64photo = base64photo;
    }
}

