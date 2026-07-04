package com.tekion.news_aggregator;

import com.tekion.news_aggregator.entity.NormalizedNewsArticle;
import com.tekion.news_aggregator.exception.InvalidSourceException;
import com.tekion.news_aggregator.factory.NormalizerFactory;
import com.tekion.news_aggregator.normalize.Normalizer;
import com.tekion.news_aggregator.sources.HinduArticle;
import com.tekion.news_aggregator.sources.SourceArticle;
import com.tekion.news_aggregator.sources.TimeNowArticle;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        System.out.println("Application Started");


        SourceArticle hinduArticle=new HinduArticle("News 1","This is the First News", Timestamp.from(Instant.now()),"/first-article");
        SourceArticle timesNowArticle=new TimeNowArticle("News 1","This is the First News",Timestamp.from(Instant.now()),"/first-article");

        NormalizerFactory factory=new NormalizerFactory();
        try {
            Normalizer normalizer = factory.getNormalizer(hinduArticle);

            NormalizedNewsArticle hinduNormalizedArticle=normalizer.normalize(hinduArticle);

            normalizer = factory.getNormalizer(timesNowArticle);

            NormalizedNewsArticle timesNowNormalizedArticle=normalizer.normalize(timesNowArticle);

            System.out.println(hinduNormalizedArticle.toString());
            System.out.println(timesNowNormalizedArticle.toString());

        }catch (InvalidSourceException e){
            System.out.println(e.getMessage());
        }


    }
}
