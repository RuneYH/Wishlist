package com.example.Wishlist;

public class Wish {
    private Long id; // ID of wish
    private String name;
    private String description;
    private double price;
    private String link;
    private String img;
    private Long listId; // ID of wishlist

    public Wish() { // --- Why do we have an empty constructor? ---
    }

    public Wish(Long id, String name, String description, double price, String link, String img, Long listId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.link = link;
        this.img = img;
        this.listId = listId;
    }

    public boolean isNew(){
        return this.id == null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }
}