package io.github.jdweeks.client;

import io.github.jdweeks.article.Article;
import io.micronaut.core.annotation.Introspected;

import java.util.Set;

@Introspected
public class NewsApiResponse {

    private String status;
    private Integer totalResults;
    private Set<Article> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
