package io.github.jdweeks.article;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Maybe;

import java.util.Set;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Get("/api/articles")
    public Set<Article> getArticles() {
        return articleService.getArticles();
    }
}
