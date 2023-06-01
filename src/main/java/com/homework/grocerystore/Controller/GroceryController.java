package com.homework.grocerystore.Controller;

import com.homework.grocerystore.Service.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class GroceryController {
    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }


   /* @GetMapping(path = "/add")
    public void addGrocery(@RequestParam("productId") int productId,
                           @RequestParam(value = "productId2", required = false) int productId2,
                           @RequestParam(value = "productId3", required = false) int productId3) {
        int [] array = {productId, productId2, productId3};

        //ArrayList<Integer> array = new ArrayList<>(List.of(productId, productId2, productId3));

        groceryService.addSimpleGrocery(array);
    }*/
    @GetMapping(path = "/add")
    public void addGrocery(@RequestParam("productId") int productId) {
        groceryService.addProduct(productId);
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
