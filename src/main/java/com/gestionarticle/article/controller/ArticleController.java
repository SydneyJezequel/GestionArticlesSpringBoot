package com.gestionarticle.article.controller;


import com.gestionarticle.article.model.Article;
import com.gestionarticle.article.model.Depot;
import com.gestionarticle.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ArticleController {


    /**
     * Injection de dépendance / Partern IO Container
     */
    @Autowired
    private ArticleService articleService;


    /**
     *
     * Méthodes CRUD
     */
    @GetMapping("/article/all")
    public ResponseEntity<List<Article>> getAllArticle()
    {
        List<Article> articles = articleService.getArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/article/find/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id)
    {
        Article article = articleService.getArticle(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @PostMapping("/article/add")
    public ResponseEntity<Article> addArticle(@RequestBody Article article)
    {   System.out.println(article);
        System.out.println(article.getPrix());
        System.out.println(article.getQuantite());
        System.out.println(article.getDesignation());
        System.out.println(article.getDateEntree()); //
        System.out.println(article.getDepot().getId()); //
        Depot depot = article.getDepot(); // Ajout du dépot
        article.setDepot(depot); // Ajout du dépot
        Article articleAdded = articleService.addArticle(article);
        return new ResponseEntity<>(articleAdded, HttpStatus.CREATED);
    }

    @PutMapping("/article/update")
    public ResponseEntity<Article> updateClient(@RequestBody Article article)
    {
        Article updateArticle = articleService.updateArticle(article);
        return new ResponseEntity<>(updateArticle, HttpStatus.OK);
    }

    @DeleteMapping("/article/delete/{id}")
    public ResponseEntity<?> deleteClasse(@PathVariable("id") Long id)
    {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
