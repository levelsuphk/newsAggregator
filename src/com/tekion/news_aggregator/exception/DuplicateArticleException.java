package com.tekion.news_aggregator.exception;

public class DuplicateArticleException extends  Exception{

    public DuplicateArticleException(String message) {
        super(message);
    }
}
