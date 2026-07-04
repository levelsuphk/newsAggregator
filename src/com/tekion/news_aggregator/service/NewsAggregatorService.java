package com.tekion.news_aggregator.service;

import com.tekion.news_aggregator.entity.NormalizedNewsArticle;
import com.tekion.news_aggregator.exception.InvalidSourceException;
import com.tekion.news_aggregator.factory.NormalizerFactory;
import com.tekion.news_aggregator.normalize.Normalizer;
import com.tekion.news_aggregator.sources.SourceArticle;

public class NewsAggregatorService {

    private static NewsAggregatorService service;
    NormalizerFactory normalizerFactory;

    private NewsAggregatorService(){
        normalizerFactory=new NormalizerFactory();
    }

    public static NewsAggregatorService getInstance(){
        if(service==null){
            service=new NewsAggregatorService();
        }

        return service;
    }

    public void addArticle(SourceArticle sourceArticle){

        try {
            Normalizer normalizer = normalizerFactory.getNormalizer(sourceArticle);

            NormalizedNewsArticle normalizedNewsArticle=normalizer.normalize(sourceArticle);

            System.out.println(normalizedNewsArticle.toString());

        }catch (InvalidSourceException e){
            System.out.println(e.getMessage());
        }
    }
}
