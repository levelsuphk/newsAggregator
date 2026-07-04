package com.tekion.news_aggregator.service;

import com.tekion.news_aggregator.entity.NormalizedNewsArticle;
import com.tekion.news_aggregator.exception.DuplicateArticleException;
import com.tekion.news_aggregator.exception.InvalidSourceException;
import com.tekion.news_aggregator.factory.NormalizerFactory;
import com.tekion.news_aggregator.normalize.Normalizer;
import com.tekion.news_aggregator.repo.NewsRepository;
import com.tekion.news_aggregator.sources.SourceArticle;

public class NewsAggregatorService {

    private static NewsAggregatorService service;
    NormalizerFactory normalizerFactory;
    NewsRepository newsRepository;

    private NewsAggregatorService(){
        normalizerFactory=new NormalizerFactory();
        newsRepository=NewsRepository.getInstance();
    }

    public static NewsAggregatorService getInstance(){
        if(service==null){
            service=new NewsAggregatorService();
        }

        return service;
    }

    public void addArticle(SourceArticle sourceArticle) throws DuplicateArticleException{

        try {
            Normalizer normalizer = normalizerFactory.getNormalizer(sourceArticle);

            NormalizedNewsArticle normalizedNewsArticle=normalizer.normalize(sourceArticle);
            if(newsRepository.isNewsArticlePresent(normalizedNewsArticle)){
                throw new DuplicateArticleException("This article with Title "+normalizedNewsArticle.getTitle()+" is already present");
            }else{
                newsRepository.save(normalizedNewsArticle);
            }

            System.out.println(normalizedNewsArticle.toString());

        }catch (InvalidSourceException e){
            System.out.println(e.getMessage());
        }
    }
}
