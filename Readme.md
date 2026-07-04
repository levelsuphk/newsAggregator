How to Run :
Open the Folder newsAggregator in Intellij
Mark the src folder as Source Root
run the main function in the Main.java

---------------------

Top Level Service :

NewsAggregatorService - Has capability to ingest news Article
NewsViewService - Has capability to get News - Sorted By Time || Filtered By Source Type

----------------------
Other Key Components :
NewsRepository :
    - singleton pattern used to access same instance of repositor across services
    - has capability to store and retrieve news
Normalizer :
    - Normalizes a SourceArticle to a NormalizedNewsArticle
    - Strategy pattern used to define different type of Normalizers for different source type
    - easy to onboard new source of article

NewsAggregatorService
    - singleton pattern used for the service
    - handles Duplication based on News Title
    - throws error on duplication

NewsViewService
    - singleton pattern used for the service
    - getNews Sorted by time - Ascending (Latest News First)
    - getNews by Source Type - Filter news by Sources

NormalizerFactory
    - factory to get corresponding Normalizers based on Source Type



