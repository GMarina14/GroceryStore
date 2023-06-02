package com.homework.grocerystore.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.grocerystore.Basket;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
//@Scope("prototype")
@SessionScope
public class GroceryServiceImpl implements GroceryService {
    private final ObjectMapper objectMapper;
    ArrayList<Basket> groceryBasket = new ArrayList<>(List.of());

    public GroceryServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void addGrocery(Collection<Integer> array) {
        if (array.size() != 0) {
            for (Integer integer : array) {
                Basket basket = new Basket(integer);
                groceryBasket.add(basket);
            }
        }
    }


    @Override
    public void addProduct(int productId) {
        Basket basket = new Basket(productId);
        groceryBasket.add(basket);
    }

    @PostConstruct
    public void init() throws JsonProcessingException {
        getGroceryList(groceryBasket);
    }

    public void getGroceryList(Collection<Basket> list) throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(list));
    }

    @Override
    public Collection<Basket> getGroceryList() {
        return Collections.unmodifiableList(groceryBasket);
    }
}
