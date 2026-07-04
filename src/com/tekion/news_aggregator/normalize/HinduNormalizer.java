package com.tekion.news_aggregator.normalize;

import com.tekion.news_aggregator.entity.NormalizedNewsArticle;
import com.tekion.news_aggregator.sources.HinduArticle;
import com.tekion.news_aggregator.sources.SourceArticle;
import com.tekion.news_aggregator.sources.SourceType;

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
