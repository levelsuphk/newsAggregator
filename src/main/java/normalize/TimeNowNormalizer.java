package normalize;

import entity.NormalizedNewsArticle;
import sources.SourceArticle;
import sources.SourceType;
import sources.TimeNowArticle;

public class TimeNowNormalizer implements Normalizer{


    @Override
    public NormalizedNewsArticle normalize(SourceArticle sourceArticle) {
        TimeNowArticle timeNowArticle=(TimeNowArticle) sourceArticle;

        NormalizedNewsArticle normalizedNewsArticle=new NormalizedNewsArticle();
        normalizedNewsArticle.setTitle(timeNowArticle.getTitle());
        normalizedNewsArticle.setSummary(timeNowArticle.getSummary());
        normalizedNewsArticle.setArticleURL(timeNowArticle.getArticleURL());
        normalizedNewsArticle.setPublishedTime(timeNowArticle.getPublishedTime());
        normalizedNewsArticle.setCategory(timeNowArticle.getCategory());
        normalizedNewsArticle.setSourceType(SourceType.TIMES_NOW);
        return normalizedNewsArticle;
    }
}
