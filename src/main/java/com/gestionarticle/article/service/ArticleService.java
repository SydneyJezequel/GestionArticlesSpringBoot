package com.gestionarticle.article.service;

import com.gestionarticle.article.exception.HandlerException;
import com.gestionarticle.article.model.Article;
import com.gestionarticle.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ArticleService {


    /**
     * Injection de dépendance / Partern IO Container
     */
    @Autowired
    private ArticleRepository articleRepository;


    /**
     *
     * Méthodes CRUD
     */
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public Article getArticle(Long id) {
        return articleRepository.findArticleById(id)
                .orElseThrow(()-> new HandlerException("Depot by id"+ id +"was not found."));
    }

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    public void deleteArticle(final Long id) {
        articleRepository.deleteById(id);
    }




}
