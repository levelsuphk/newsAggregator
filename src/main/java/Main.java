import entity.NormalizedNewsArticle;
import exception.DuplicateArticleException;
import repo.NewsRepository;
import service.NewsAggregatorService;
import service.NewsViewService;
import sources.HinduArticle;
import sources.SourceArticle;
import sources.SourceType;
import sources.TimeNowArticle;

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
        NewsRepository newsRepository=new NewsRepository();
        NewsAggregatorService service=new NewsAggregatorService(newsRepository);

        try {
            service.addArticle(hinduArticle);
            service.addArticle(timesNowArticle);
            service.addArticle(timesNowArticle2);
        }catch(DuplicateArticleException e){
            System.out.println("Exception : "+e.getMessage());
        }
        System.out.println("----------------");

        NewsViewService newsViewService=new NewsViewService(newsRepository);

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
