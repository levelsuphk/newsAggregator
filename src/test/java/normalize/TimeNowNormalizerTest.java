package normalize;

import entity.NormalizedNewsArticle;
import org.junit.jupiter.api.Test;
import sources.SourceType;
import sources.TimeNowArticle;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeNowNormalizerTest {

    @Test
    public void shouldNormalizeTimesNowArticle(){
        Timestamp publishedTime=Timestamp.valueOf("2026-07-04 10:00:00");

        TimeNowArticle article=new TimeNowArticle(
                "India wins test series",
                "India defeats England",
                publishedTime,
                "https://timesnow.com/article1"
        );

        article.setCategory(List.of("Sports"));

        TimeNowNormalizer normalizer=new TimeNowNormalizer();
        NormalizedNewsArticle normalizedNewsArticle=normalizer.normalize(article);

        assertEquals("India wins test series",normalizedNewsArticle.getTitle());
        assertEquals("India defeats England",normalizedNewsArticle.getSummary());
        assertEquals(publishedTime,normalizedNewsArticle.getPublishedTime());
        assertEquals("https://timesnow.com/article1",normalizedNewsArticle.getArticleURL());
        assertEquals(List.of("Sports"),normalizedNewsArticle.getCategory());
        assertEquals(SourceType.TIMES_NOW,normalizedNewsArticle.getSourceType());
    }
}
