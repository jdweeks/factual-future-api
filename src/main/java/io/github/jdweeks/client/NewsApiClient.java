package io.github.jdweeks.client;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

import javax.inject.Singleton;
import java.net.URI;

@Singleton
public class NewsApiClient {

    private final NewsApiProperties props;
    private final RxHttpClient client;

    public NewsApiClient(@Client RxHttpClient client, NewsApiProperties props) {
        this.client = client;
        this.props = props;
    }

    public Maybe<NewsApiResponse> fetchArticles() {
        URI api = UriBuilder.of(props.getUri() + "?sources=" + props.getSources()).build();

        HttpRequest<?> req = HttpRequest.GET(api).bearerAuth(props.getToken());
        Flowable<?> flow = client.retrieve(req, NewsApiResponse.class);

        return (Maybe<NewsApiResponse>) flow.firstElement();
    }
}
