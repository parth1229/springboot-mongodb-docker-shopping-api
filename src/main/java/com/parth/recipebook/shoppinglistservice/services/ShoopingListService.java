package com.parth.recipebook.shoppinglistservice.services;

import com.parth.recipebook.shoppinglistservice.dao.ShoppingListRepository;
import com.parth.recipebook.shoppinglistservice.models.UserShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoopingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public UserShoppingList getUserShoppingList(String id){
        return this.shoppingListRepository.findByUserId(id);
    }

    public void saveUserShoppingList(UserShoppingList userShoppingList){
        this.shoppingListRepository.save(userShoppingList);
    }
}
