package service;


import entity.NormalizedNewsArticle;
import exception.DuplicateArticleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repo.NewsRepository;
import sources.HinduArticle;

import java.sql.Timestamp;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewsAggregatorServiceTest {

    @Mock
    private NewsRepository newsRepository;

    private NewsAggregatorService newsAggregatorService;

    @BeforeEach
    void setUp(){
        newsAggregatorService=new NewsAggregatorService(newsRepository);
    }

    @Test
    void shouldSaveArticleWhenNotAlreadyPresent() throws DuplicateArticleException {

        HinduArticle article = new HinduArticle(
                "India wins",
                "Summary",
                Timestamp.valueOf("2026-07-04 10:00:00"),
                "https://abc.com"
        );

        article.setCategory(List.of("Sports"));

        when(newsRepository.isNewsArticlePresent(any()))
                .thenReturn(false);

        newsAggregatorService.addArticle(article);

        verify(newsRepository).save(any(NormalizedNewsArticle.class));
    }



}
