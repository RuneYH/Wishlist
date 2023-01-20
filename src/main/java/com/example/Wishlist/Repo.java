package com.example.Wishlist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Repo {

//    private List<User> users;
//    private List<Wishlist> wishlists;
    private List<Wish> wishes;

    public Repo() { // Constructor
        wishes = new ArrayList<>(); // Holds all the wishes

        // Pre-fill dummy data can be removed later
        for (int i = 1; i <= 15; i++) {
            wishes.add(new Wish(new Long(i), "Wish " + i, "This is a really nice gift that I would appreciate a lot.", 200 + i, "https://google.com","",new Long(0)));
        }
    }

    // Get one wish
    public Wish getWish(Long id) {
        for (Wish wish : wishes) {
            if (wish.getId().equals(id)) {
                return wish;
            }
        }
        return null;
    }

    // Get all wishes
    public List<Wish> getWishes() {
        return wishes;
    }

    // Add a wish
    public Wish addWish(Wish wish) {
        Wish lastWish = wishes.get(wishes.size()-1);
        wish.setListId(lastWish.getListId()+1); // set an id on the new book, should be unique, will be done by the database in future exercises
        wishes.add(wish);
        return wish;
    }

    // Edit a wish
    public Wish editWish(Wish wish) {
        Wish wishToEdit = this.getWish(wish.getId());
        if (wishToEdit != null) {
            wishToEdit.setName(wish.getName());
            wishToEdit.setPrice(wish.getPrice());
            wishToEdit.setLink(wish.getLink());
            wishToEdit.setImg(wish.getImg());
            wishToEdit.setDescription(wish.getDescription());
        }
        return wish;
    }

    // Delete a wish (yet to be implemented)
    public void deleteWish(Long id) {
        Wish wishToDelete = this.getWish(id);
        if (wishToDelete != null) {
            wishes.remove(wishToDelete);
        }
    }
}
