package ru.carcrew.boot.version_20.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.carcrew.boot.version_20.models.Article;
import ru.carcrew.boot.version_20.models.User;
import ru.carcrew.boot.version_20.repositories.ArticleRepository;
import ru.carcrew.boot.version_20.repositories.UsersRepository;

import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, UsersRepository usersRepository) {
        this.articleRepository = articleRepository;
        this.usersRepository = usersRepository;
    }

    @Transactional
    public void newArticle(Article article){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String ownerUsername = authentication.getName();

        // Устанавливаем владельца статьи
        Optional<User> userOptional = usersRepository.findByUsername(ownerUsername);
        User owner = userOptional.orElseThrow(() -> new RuntimeException("User not found"));
        article.setOwner(owner);



        articleRepository.save(article);
    }


}
