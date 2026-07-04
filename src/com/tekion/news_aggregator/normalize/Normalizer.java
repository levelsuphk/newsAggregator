package com.tekion.news_aggregator.normalize;

import com.tekion.news_aggregator.entity.NormalizedNewsArticle;
import com.tekion.news_aggregator.sources.SourceArticle;

public interface Normalizer {

    public NormalizedNewsArticle normalize(SourceArticle sourceArticle);
}
