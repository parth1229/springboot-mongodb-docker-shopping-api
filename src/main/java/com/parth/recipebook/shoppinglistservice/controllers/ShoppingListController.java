package com.parth.recipebook.shoppinglistservice.controllers;

import com.parth.recipebook.shoppinglistservice.models.UserShoppingList;
import com.parth.recipebook.shoppinglistservice.services.ShoopingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingListController {

    @Autowired
    private ShoopingListService shoopingListService;

    @RequestMapping(value = "/userIngredients/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getShoppingList(@RequestParam("userId") String email){
        if(email == null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Request require a valid user Id");
        }
        else {
            try{
                UserShoppingList userShoppingList = this.shoopingListService.getUserShoppingList(email);
                if(userShoppingList == null){
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body("Shopping List not found for " + userShoppingList.getId());
                }
                else {
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body(userShoppingList);
                }
            }catch (Exception ex){
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error while parsing data.");
            }
        }
    }

    @RequestMapping(value = "/userIngredients", method = RequestMethod.POST)
    public ResponseEntity<?> getShoppingList(@RequestBody UserShoppingList userShoppingList){
        if(userShoppingList == null){
            return ResponseEntity.status(HttpStatus.OK).body("Nothing to save");
        }
        this.shoopingListService.saveUserShoppingList(userShoppingList);
        return ResponseEntity.status(HttpStatus.OK).body("Shopping list Saved for " + userShoppingList.getId());
    }
}
