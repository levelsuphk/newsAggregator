package com.tekion.news_aggregator.service;

import com.tekion.news_aggregator.entity.NormalizedNewsArticle;
import com.tekion.news_aggregator.repo.NewsRepository;
import com.tekion.news_aggregator.sources.SourceType;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NewsViewService {

    private static NewsViewService newsViewService;
    NewsRepository newsRepository;
    private NewsViewService(){
        this.newsRepository=NewsRepository.getInstance();
    }

    public static NewsViewService getInstance(){
        if(newsViewService==null){
            newsViewService=new NewsViewService();
        }
        return newsViewService;
    }

    public List<NormalizedNewsArticle> getNewsByTime(){
        List<NormalizedNewsArticle> newsArticleList=newsRepository.getNormalizedNewsList();
        newsArticleList.sort(Comparator.comparing(NormalizedNewsArticle::getPublishedTime).reversed());
        return newsArticleList;
    }

    public List<NormalizedNewsArticle> getNewsBySource(SourceType sourceType){
        List<NormalizedNewsArticle> newsArticleList=newsRepository.getNormalizedNewsList();
        List<NormalizedNewsArticle> filteredList = newsArticleList.stream()
                .filter(article -> article.getSourceType() == sourceType)
                .collect(Collectors.toList());

        return filteredList;
    }

    public List<NormalizedNewsArticle> getNewsByCategory(String category){
        // need to implement category based function.
        // Adding a stub due to time constrain
        return null;
    }


}
