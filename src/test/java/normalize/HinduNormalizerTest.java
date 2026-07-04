package normalize;

import entity.NormalizedNewsArticle;
import org.junit.jupiter.api.Test;
import sources.HinduArticle;
import sources.SourceType;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HinduNormalizerTest {


    @Test
    void shouldNormalizeHinduArticle() {
        Timestamp publishedTime=Timestamp.valueOf("2026-07-04 10:00:00");

        HinduArticle article = new HinduArticle(
                "India wins test series",
                "India defeats England",
                publishedTime,
                "https://thehindu.com/article1"
        );

        article.setCategory(List.of("Sports"));

        HinduNormalizer normalizer = new HinduNormalizer();

        NormalizedNewsArticle normalized = normalizer.normalize(article);

        assertEquals("India wins test series", normalized.getTitle());
        assertEquals("India defeats England", normalized.getSummary());
        assertEquals(publishedTime, normalized.getPublishedTime());
        assertEquals("https://thehindu.com/article1", normalized.getArticleURL());
        assertEquals(List.of("Sports"), normalized.getCategory());
        assertEquals(SourceType.HINDU, normalized.getSourceType());
    }
}
