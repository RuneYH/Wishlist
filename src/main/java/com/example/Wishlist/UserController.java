package com.example.Wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/uwish")
    public String start() {
        return "start";
    }

    @GetMapping("/uwish/signup")
    public String signup(Model model) {
        model.addAttribute("user1", new User1());
        return "signup";
    }

    @PostMapping("/uwish/saveuser")
    public String saveUser(@ModelAttribute User1 user1) {
        userRepo.save(user1);
        return "redirect:/uwish/wishlist";
    }

    @GetMapping("/uwish/login")
    public String login() {
        return "login";
    }

    @GetMapping("/uwish/logout")
    public String logout() {
        return "login";
    }
}