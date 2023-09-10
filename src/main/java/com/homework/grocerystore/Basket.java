package com.homework.grocerystore;

import java.util.Objects;

public class Basket {
    private int productID;

    public Basket(int productID) {
        if (productID > 0)
            this.productID = productID;
        else
            throw new IllegalArgumentException();
    }

    public int getProductID() {
        return productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return productID == basket.productID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }

    @Override
    public String toString() {
        return "Basket: " +
                "productID=" + productID;
    }
}
