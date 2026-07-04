package service;

import entity.NormalizedNewsArticle;
import repo.NewsRepository;
import sources.SourceType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NewsViewService {

    NewsRepository newsRepository;

    public NewsViewService(NewsRepository newsRepository){
        this.newsRepository=newsRepository;
    }

    public List<NormalizedNewsArticle> getNewsByTime(){
        List<NormalizedNewsArticle> newsArticleList =
                new ArrayList<>(newsRepository.getNormalizedNewsList());
        newsArticleList.sort(Comparator.comparing(NormalizedNewsArticle::getPublishedTime).reversed());
        return newsArticleList;
    }

    public List<NormalizedNewsArticle> getNewsBySource(SourceType sourceType){
        List<NormalizedNewsArticle> newsArticleList =
                new ArrayList<>(newsRepository.getNormalizedNewsList());
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
