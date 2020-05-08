package com.parth.recipebook.shoppinglistservice.dao;

import com.parth.recipebook.shoppinglistservice.models.UserShoppingList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends MongoRepository<UserShoppingList, String> {
    public UserShoppingList findByUserId(String userId);
}
