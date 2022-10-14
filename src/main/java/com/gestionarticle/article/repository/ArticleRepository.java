package com.gestionarticle.article.repository;

import com.gestionarticle.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    void deleteArticleById(Long id);

    Optional<Article> findArticleById(Long id);


}
