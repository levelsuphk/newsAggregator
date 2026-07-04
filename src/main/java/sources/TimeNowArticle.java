package sources;

import java.sql.Timestamp;
import java.util.List;

public class TimeNowArticle extends SourceArticle{

    String title;
    String summary;
    Timestamp publishedTime;
    String articleURL;
    List<String> category;

    public TimeNowArticle(String title, String summary, Timestamp publishedTime, String articleURL) {
        super(SourceType.TIMES_NOW);
        this.title = title;
        this.summary = summary;
        this.publishedTime = publishedTime;
        this.articleURL = articleURL;
    }

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
}
