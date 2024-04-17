package ru.carcrew.boot.version_20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.carcrew.boot.version_20.models.Article;
import ru.carcrew.boot.version_20.repositories.ArticleRepository;
import ru.carcrew.boot.version_20.servicies.ArticleService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/mainPages")
public class ArticleController {

    public ArticleController(){}

   private  ArticleRepository articleRepository;
   private  ArticleService articleService;


   @Autowired
   public ArticleController(ArticleService articleService, ArticleRepository articleRepository){
       this.articleRepository = articleRepository;
       this.articleService = articleService;

   }

    @GetMapping("/addArticle")
    public String sendArticle(@ModelAttribute("article")Article article) {
        return "/mainPages/addArticle";
    }

    @PostMapping("/addArticle")
    public String create(@ModelAttribute("article") @Valid Article article,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/mainPages/addArticle";

        articleService.newArticle(article);
        return "redirect:/mainPages/discussions";
    }

    @GetMapping("/discussions")
    public String viewArticles(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "/mainPages/discussions";
    }


}
