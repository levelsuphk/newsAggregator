package normalize;

import entity.NormalizedNewsArticle;
import sources.HinduArticle;
import sources.SourceArticle;
import sources.SourceType;

public class HinduNormalizer implements Normalizer{

    @Override
    public NormalizedNewsArticle normalize(SourceArticle sourceArticle) {
        HinduArticle hinduArticle=(HinduArticle) sourceArticle;

        NormalizedNewsArticle normalizedNewsArticle=new NormalizedNewsArticle();
        normalizedNewsArticle.setTitle(hinduArticle.getTitle());
        normalizedNewsArticle.setSummary(hinduArticle.getSummary());
        normalizedNewsArticle.setArticleURL(hinduArticle.getArticleURL());
        normalizedNewsArticle.setPublishedTime(hinduArticle.getPublishedTime());
        normalizedNewsArticle.setCategory(hinduArticle.getCategory());
        normalizedNewsArticle.setSourceType(SourceType.HINDU);
        return normalizedNewsArticle;
    }
}
