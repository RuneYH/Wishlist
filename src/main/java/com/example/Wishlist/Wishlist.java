package com.example.Wishlist;

public class Wishlist {
    String name;
    Long id; // ID of wishlist
    Long userId; // ID of user

    // wishlist[]


    public Wishlist(String name, Long id, Long userId) {
        this.name = name;
        this.id = id;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
