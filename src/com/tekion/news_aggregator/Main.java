package com.tekion.news_aggregator;

import com.tekion.news_aggregator.entity.NormalizedNewsArticle;
import com.tekion.news_aggregator.exception.DuplicateArticleException;
import com.tekion.news_aggregator.service.NewsAggregatorService;
import com.tekion.news_aggregator.service.NewsViewService;
import com.tekion.news_aggregator.sources.HinduArticle;
import com.tekion.news_aggregator.sources.SourceArticle;
import com.tekion.news_aggregator.sources.SourceType;
import com.tekion.news_aggregator.sources.TimeNowArticle;

import java.sql.Timestamp;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        System.out.println("Application Started");


        System.out.println("----------------");

        SourceArticle hinduArticle=new HinduArticle("News 1","This is the First News", Timestamp.from(Instant.now()),"/article-url");
        SourceArticle timesNowArticle=new TimeNowArticle("News 2","This is the First News",Timestamp.from(Instant.now()),"/article-url");

        //Duplicate Article
        SourceArticle timesNowArticle2=new TimeNowArticle("News 1","This is the First News",Timestamp.from(Instant.now()),"/article-url");
        NewsAggregatorService service=NewsAggregatorService.getInstance();

        try {
            service.addArticle(hinduArticle);
            service.addArticle(timesNowArticle);
            service.addArticle(timesNowArticle2);
        }catch(DuplicateArticleException e){
            System.out.println("Exception : "+e.getMessage());
        }
        System.out.println("----------------");

        NewsViewService newsViewService=NewsViewService.getInstance();

        //Sorted By Time
        System.out.println("Sorted By Time : ");
        for(NormalizedNewsArticle article : newsViewService.getNewsByTime()){
            System.out.println(article.toString());
        }

        System.out.println("----------------");

        System.out.println("Fitering by Type - Hindu Article : ");
        for(NormalizedNewsArticle article : newsViewService.getNewsBySource(SourceType.HINDU)){
            System.out.println(article.toString());
        }

        System.out.println("----------------");

        System.out.println("Fitering by Type - Times Now Article : ");
        for(NormalizedNewsArticle article : newsViewService.getNewsBySource(SourceType.TIMES_NOW)){
            System.out.println(article.toString());
        }

    }
}
