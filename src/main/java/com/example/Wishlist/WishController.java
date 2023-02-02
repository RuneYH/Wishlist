package com.example.Wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WishController {

    private static final int PAGE_SIZE = 10; // Shows only 10 wishes per page
    @Autowired
    private WishRepo wishRepo;

    @GetMapping("/uwish/") // Wishlist
    public String wishes(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {

        List<Wish> wishes = getPage(page-1, PAGE_SIZE);
        int pageCount = numberOfPages(PAGE_SIZE);
        int[] pages = toArray(pageCount);

        model.addAttribute("wishes", wishes);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("showPrev", page > 1);
        model.addAttribute("showNext", page < pageCount);

        return "wishes";
    }

    @GetMapping("/uwish/wish/{page}/{id}")
    public String wish(Model model, @PathVariable Integer page, @PathVariable Long id) {
        Wish wish = wishRepo.findById(id).orElse(null);
        model.addAttribute("page", page);
        model.addAttribute("wish", wish);

        return "wish";
    }

    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }

    private List<Wish> getPage(int page, int pageSize) {
        List<Wish> wishes = (List<Wish>) wishRepo.findAll();
        int from = Math.max(0,page*pageSize);
        int to = Math.min(wishes.size(),(page+1)*pageSize);

        return wishes.subList(from, to);
    }

    private int numberOfPages(int pageSize) {
        List<Wish> wishes = (List<Wish>) wishRepo.findAll();
        return (int)Math.ceil(new Double(wishes.size()) / pageSize);
    }

    @GetMapping("/uwish/add")
    public String add(Model model) {
        model.addAttribute("wish", new Wish());
        return "add_edit";
    }

    @PostMapping("/uwish/save")
    public String set(@ModelAttribute Wish wish) {
        wishRepo.save(wish);
        return "redirect:/uwish/";
    }

    @GetMapping("/uwish/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Wish wish = wishRepo.findById(id).get();
        model.addAttribute(wish);
        return "add_edit";
    }

    @GetMapping("/uwish/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        wishRepo.deleteById(id);
        return "redirect:/uwish/";
    }
}