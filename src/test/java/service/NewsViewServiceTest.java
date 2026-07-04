package service;

import entity.NormalizedNewsArticle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repo.NewsRepository;
import sources.SourceType;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NewsViewServiceTest {

    @Mock
    private NewsRepository repository;

    private NewsViewService service;

    @BeforeEach
    void setUp() {
        service = new NewsViewService(repository);
    }

    @Test
    void shouldReturnOnlyHinduArticles() {

        NormalizedNewsArticle article1 = createArticle("A", SourceType.HINDU);
        NormalizedNewsArticle article2 = createArticle("B", SourceType.TIMES_NOW);
        NormalizedNewsArticle article3 = createArticle("C", SourceType.HINDU);

        when(repository.getNormalizedNewsList())
                .thenReturn(List.of(article1, article2, article3));

        List<NormalizedNewsArticle> result =
                service.getNewsBySource(SourceType.HINDU);

        assertEquals(2, result.size());

        assertTrue(result.stream()
                .allMatch(article ->
                        article.getSourceType() == SourceType.HINDU));
    }

    @Test
    void shouldReturnArticlesSortedByPublishedTime() {

        NormalizedNewsArticle oldArticle =
                createArticle("Old", SourceType.HINDU);

        oldArticle.setPublishedTime(
                Timestamp.valueOf("2026-07-04 09:00:00"));

        NormalizedNewsArticle newArticle =
                createArticle("New", SourceType.HINDU);

        newArticle.setPublishedTime(
                Timestamp.valueOf("2026-07-04 11:00:00"));

        when(repository.getNormalizedNewsList())
                .thenReturn(new ArrayList<>(List.of(oldArticle, newArticle)));

        List<NormalizedNewsArticle> result =
                service.getNewsByTime();

        assertEquals("New", result.get(0).getTitle());
        assertEquals("Old", result.get(1).getTitle());
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
