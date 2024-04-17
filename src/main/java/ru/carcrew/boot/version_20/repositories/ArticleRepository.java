package ru.carcrew.boot.version_20.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.carcrew.boot.version_20.models.Article;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findByTopic(String topic);
}
