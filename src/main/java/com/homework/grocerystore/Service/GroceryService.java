package com.homework.grocerystore.Service;

import com.homework.grocerystore.Basket;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Scope("prototype")
public interface GroceryService {
   // public void addGrocery(Collection<Integer> array);
    public void addProduct(int productId);
    public Collection<Basket> getGroceryList();
    //public void addSimpleGrocery(int[] array);

}
