package com.tekion.news_aggregator.sources;

public abstract class SourceArticle {

    SourceType sourceType;

    public SourceArticle(SourceType sourceType){
        this.sourceType=sourceType;
    }

    public SourceType getSourceType(){
        return this.sourceType;
    }

}
