package io.github.jdweeks.client;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties(NewsApiProperties.PREFIX)
public class NewsApiProperties {

    public static final String PREFIX = "newsapi";

    private String uri;
    private String token;
    private String sources;

    public NewsApiProperties() {
    }

    public NewsApiProperties(String uri, String token, String sources) {
        this.uri = uri;
        this.token = token;
        this.sources = sources;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSources() {
        return this.sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }
}