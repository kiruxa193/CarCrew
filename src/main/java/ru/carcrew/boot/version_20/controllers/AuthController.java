package ru.carcrew.boot.version_20.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.carcrew.boot.version_20.models.User;
import ru.carcrew.boot.version_20.security.PersonDetails;
import ru.carcrew.boot.version_20.servicies.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    public AuthController() {}

    private RegistrationService registrationService;


    @Autowired
    public AuthController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping("/login")
    public String loginPage(){
        return "/auth/login";
    }

    @GetMapping("/registr")
    public String newPerson(@ModelAttribute("user") User user) {
        return "/auth/registr";
    }

    @PostMapping("/registr")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/auth/registr";

        registrationService.regtion(user);
        return "redirect:/mainPages/main";
    }

    @GetMapping("/showUserInfo")

    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return "/auth/hello";


    }
}
