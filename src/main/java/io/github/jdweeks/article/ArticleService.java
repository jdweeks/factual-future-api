package io.github.jdweeks.article;

import io.github.jdweeks.client.NewsApiClient;
import io.reactivex.Maybe;

import javax.inject.Singleton;
import java.util.Set;

@Singleton
public class ArticleService {

    private final NewsApiClient newsClient;

    public ArticleService(NewsApiClient newsClient) {
        this.newsClient = newsClient;
    }

    public Set<Article> getArticles() {
        return newsClient.fetchArticles().blockingGet().getArticles();
    }
}
