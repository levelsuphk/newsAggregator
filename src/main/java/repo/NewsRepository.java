package repo;

import entity.NormalizedNewsArticle;

import java.util.*;

public class NewsRepository {

    public NewsRepository(){
        this.newsTitleSet=new HashSet<>();
        this.newsArticleMap=new HashMap<>();
    }

    Set<String> newsTitleSet;
    Map<String,NormalizedNewsArticle> newsArticleMap;



    public void save(NormalizedNewsArticle normalizedNewsArticle){
        if(!newsTitleSet.contains(normalizedNewsArticle.getTitle())){
            newsTitleSet.add(normalizedNewsArticle.getTitle());
            newsArticleMap.put(normalizedNewsArticle.getTitle(),normalizedNewsArticle);
        }

    }

    public boolean isNewsArticlePresent(NormalizedNewsArticle normalizedNewsArticle){
        return newsTitleSet.contains(normalizedNewsArticle.getTitle());
    }

    public List<NormalizedNewsArticle> getNormalizedNewsList(){
        return new ArrayList<>(newsArticleMap.values());
    }


}
