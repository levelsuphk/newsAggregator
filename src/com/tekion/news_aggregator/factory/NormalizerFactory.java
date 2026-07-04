package com.tekion.news_aggregator.factory;

import com.tekion.news_aggregator.exception.InvalidSourceException;
import com.tekion.news_aggregator.normalize.HinduNormalizer;
import com.tekion.news_aggregator.normalize.Normalizer;
import com.tekion.news_aggregator.normalize.TimeNowNormalizer;
import com.tekion.news_aggregator.sources.SourceArticle;
import com.tekion.news_aggregator.sources.SourceType;


public class NormalizerFactory {

    public Normalizer getNormalizer(SourceArticle sourceArticle) throws InvalidSourceException{
        SourceType incomingSourceType=sourceArticle.getSourceType();
        switch (incomingSourceType){
            case SourceType.TIMES_NOW:
                return new TimeNowNormalizer();
            case SourceType.HINDU:
                return new HinduNormalizer();
            default:
                throw new InvalidSourceException("Unsupported Source");
        }
    }
}
