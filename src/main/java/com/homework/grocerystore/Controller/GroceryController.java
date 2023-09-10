package com.homework.grocerystore.Controller;

import com.homework.grocerystore.Service.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class GroceryController {
    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @RequestMapping(path = "/add")
    public void addGrocery(@RequestParam List<Integer> product) {
        groceryService.addGrocery(product);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<?> getTheList() {
        if (groceryService.getGroceryList().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(groceryService.getGroceryList());
        }
    }
}
