package ru.aplk.management;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.aplk.management.users.User;
import ru.aplk.management.users.UserRepo;


@Controller
@RequiredArgsConstructor
public class WebController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/auth/register")
    public String saveUser(@ModelAttribute User user) {
        userRepo.save(user);
        return "redirect:/auth/login"; // перенаправление на страницу успеха
    }

    @GetMapping("/auth/register")
    public String registerPage(@ModelAttribute("user") User user){
        return "auth/register";
    }


    @GetMapping("/auth/login")
    public String loginPage(@ModelAttribute("user") User user){
        //return "redirect:/shop";
        return "/auth/login";

    }

    @GetMapping("/shop")
    public String booksPage(@ModelAttribute("user") User user){
        return "auth/shop";
    }

}
