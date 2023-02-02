package com.example.Wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WisherController {

    @Autowired
    private WisherRepo wisherRepo;

    @GetMapping("/uwish")
    public String start() {
        return "start";
    }

    @GetMapping("/uwish/signup")
    public String signup(Model model) {
        model.addAttribute("wisher", new Wisher());
        return "signup";
    }

    @PostMapping("/uwish/savewisher")
    public String saveWisher(@ModelAttribute Wisher wisher) {
        wisherRepo.save(wisher);
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