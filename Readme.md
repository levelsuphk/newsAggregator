# News Aggregator

## Overview

A simple News Aggregator application that collects news articles from multiple providers, normalizes them into a common format, and allows users to view articles sorted by publish time or filtered by source.

The project demonstrates clean object-oriented design using the **Factory** and **Repository** patterns and includes comprehensive unit tests using **JUnit 5** and **Mockito**.

---

## Features

* Aggregate news from multiple news providers
* Normalize provider-specific article formats
* Prevent duplicate news articles
* View articles sorted by latest published time
* Filter articles by news source
* Easily extensible to support additional news providers

---

## Project Structure

```text
src
├── main
│   └── java
│       ├── entity
│       ├── exception
│       ├── factory
│       ├── normalize
│       ├── repo
│       ├── service
│       ├── sources
│       └── Main.java
│
└── test
    └── java
```

---

## Important Classes

### SourceArticle

Abstract representation of a news article received from an external provider. Each provider has its own implementation (e.g. `HinduArticle`, `TimesNowArticle`).

---

### NormalizedNewsArticle

Represents the application's internal news model after normalization. All downstream components work only with this class.

---

### Normalizer

Defines the contract for converting provider-specific articles into a `NormalizedNewsArticle`.

Implementations:

* `HinduNormalizer`
* `TimesNowNormalizer`

Adding support for a new provider only requires implementing another `Normalizer`.

---

### NormalizerFactory

Uses the Factory Pattern to return the correct `Normalizer` implementation based on the incoming article source.

This keeps the aggregation logic independent of provider-specific implementations.

---

### NewsRepository

Acts as the in-memory data store for normalized news articles.

Responsibilities:

* Store normalized articles
* Detect duplicate articles
* Retrieve all stored articles

---

### NewsAggregatorService

Coordinates the news ingestion workflow.

Responsibilities:

* Obtain the appropriate normalizer
* Normalize incoming articles
* Detect duplicates
* Persist normalized articles

---

### NewsViewService

Provides read operations over the stored articles.

Responsibilities:

* Retrieve articles sorted by publish time
* Filter articles by news source

---

## Design Patterns

### Factory Pattern

Used by `NormalizerFactory` to create the correct `Normalizer` implementation without exposing object creation logic to the service layer.

### Repository Pattern

Used by `NewsRepository` to encapsulate data storage and retrieval, keeping business logic independent of persistence details.

---

## Running the Application

```bash
mvn compile
mvn exec:java
```

Or simply run the `Main` class from IntelliJ.

---

## Running Tests

```bash
mvn test
```

The project uses:

* JUnit 5
* Mockito

---

## Future Enhancements

* Implement category-based filtering
* Support additional news providers
* Persist articles in a database
* Add pagination for large datasets
* Replace console output with structured logging
