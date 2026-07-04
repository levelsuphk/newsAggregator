package factory;

import exception.InvalidSourceException;
import normalize.HinduNormalizer;
import normalize.Normalizer;
import normalize.TimeNowNormalizer;
import sources.SourceArticle;
import sources.SourceType;


public class NormalizerFactory {

    public Normalizer getNormalizer(SourceArticle sourceArticle) throws InvalidSourceException{
        SourceType incomingSourceType=sourceArticle.getSourceType();
        switch (incomingSourceType){
            case SourceType.TIMES_NOW:
                return new TimeNowNormalizer();
            case SourceType.HINDU:
                return new HinduNormalizer();
            default:
                throw new InvalidSourceException("Unsupported Source");
        }
    }
}
