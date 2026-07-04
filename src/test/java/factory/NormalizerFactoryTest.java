package factory;

import exception.InvalidSourceException;
import normalize.HinduNormalizer;
import normalize.Normalizer;
import org.junit.jupiter.api.Test;
import sources.HinduArticle;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NormalizerFactoryTest {

    @Test
    void shouldReturnHinduNormalizer() throws InvalidSourceException {

        NormalizerFactory factory = new NormalizerFactory();

        HinduArticle article = new HinduArticle(
                "Title",
                "Summary",
                Timestamp.valueOf("2026-07-04 10:00:00"),
                "https://abc.com"
        );

        Normalizer normalizer = factory.getNormalizer(article);

        assertTrue(normalizer instanceof HinduNormalizer);
    }
}
