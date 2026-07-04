package entity;

import sources.SourceType;

import java.sql.Timestamp;
import java.util.List;

public class NormalizedNewsArticle {
    String title;
    String summary;
    Timestamp publishedTime;
    String articleURL;
    List<String> category;
    SourceType sourceType;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Timestamp getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Timestamp publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getArticleURL() {
        return articleURL;
    }

    public void setArticleURL(String articleURL) {
        this.articleURL = articleURL;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void setSourceType(SourceType sourceType){
        this.sourceType=sourceType;
    }

    public SourceType getSourceType(){
        return this.sourceType;
    }

    @Override
    public String toString() {
        return "NormalizedNewsArticle{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", publishedTime=" + publishedTime +
                ", articleURL='" + articleURL + '\'' +
                ", category=" + category +
                ", sourceType=" + sourceType +
                '}';
    }
}
