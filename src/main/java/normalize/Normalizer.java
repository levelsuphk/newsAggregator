package normalize;

import entity.NormalizedNewsArticle;
import sources.SourceArticle;

public interface Normalizer {

    public NormalizedNewsArticle normalize(SourceArticle sourceArticle);
}
