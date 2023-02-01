package com.example.Wishlist;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WishRepo extends CrudRepository<Wish, Long> {

}
