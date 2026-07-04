package repo;

import entity.NormalizedNewsArticle;
import org.junit.jupiter.api.Test;
import sources.SourceType;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewsRepositoryTest {

    @Test
    void shouldSaveNewsArticle() {

        NewsRepository repository = new NewsRepository();
        NormalizedNewsArticle article = createArticle("India wins",SourceType.HINDU);

        repository.save(article);

        assertTrue(repository.isNewsArticlePresent(article));
        assertEquals(1, repository.getNormalizedNewsList().size());
    }

    @Test
    void shouldNotSaveDuplicateNewsArticle() {

        NewsRepository repository = new NewsRepository();


        NormalizedNewsArticle article = createArticle("India wins",SourceType.HINDU);

        repository.save(article);
        repository.save(article);

        assertEquals(1, repository.getNormalizedNewsList().size());
    }

    @Test
    void shouldReturnAllSavedArticles() {

        NewsRepository repository = new NewsRepository();

        repository.save(createArticle("Title 1", SourceType.HINDU));
        repository.save(createArticle("Title 2", SourceType.TIMES_NOW));

        List<NormalizedNewsArticle> articles = repository.getNormalizedNewsList();

        assertEquals(2, articles.size());
    }


    private NormalizedNewsArticle createArticle(
            String title,
            SourceType sourceType) {

        NormalizedNewsArticle normalizedNewsArticle= new NormalizedNewsArticle();

        normalizedNewsArticle.setTitle(title);
        normalizedNewsArticle.setSourceType(sourceType);
        normalizedNewsArticle.setPublishedTime(Timestamp.valueOf("2026-07-04 10:00:00"));
        normalizedNewsArticle.setSummary("Summary");
        normalizedNewsArticle.setCategory(List.of("Sports"));
        normalizedNewsArticle.setArticleURL("https://abc.com/");

        return normalizedNewsArticle;


    }
}
