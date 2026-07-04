package service;

import entity.NormalizedNewsArticle;
import exception.DuplicateArticleException;
import exception.InvalidSourceException;
import factory.NormalizerFactory;
import normalize.Normalizer;
import repo.NewsRepository;
import sources.SourceArticle;

public class NewsAggregatorService {

    NormalizerFactory normalizerFactory;
    NewsRepository newsRepository;

    public NewsAggregatorService(NewsRepository newsRepository){
        normalizerFactory=new NormalizerFactory();
        this.newsRepository=newsRepository;
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
