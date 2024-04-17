package ru.carcrew.boot.version_20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.carcrew.boot.version_20.repositories.UsersRepository;
import ru.carcrew.boot.version_20.security.PersonDetails;

@Controller
@RequestMapping("/mainPages")
public class UserController {
    private final UsersRepository usersRepository;

    @Autowired
    public UserController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/profile")
    public String showUserProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            model.addAttribute("username", username);

            if (authentication.getPrincipal() instanceof PersonDetails) {
                PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();
                // Передайте другие данные пользователя в модель по необходимости
                model.addAttribute("email", personDetails.getEmail());
            }
        }

        return "mainPages/profile";
    }


    @GetMapping("/main")
    public String showMain() {
        return "mainPages/main";
    }

    @GetMapping("/event")
    public String showEvent() {
        return "mainPages/event";
    }


    @GetMapping("/shop")
    public String showShop() {
        return "mainPages/shop";
    }



}