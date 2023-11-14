package org.example;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public record Order(String orderId, Map<Product,Integer> orderedProducts, String shippingAddress, BigDecimal totalPrice) {
    public Order computeAndPlaceTotalPrice(){
        BigDecimal totalPrice1 = new BigDecimal("0");

        for(Product product : orderedProducts.keySet()){

            BigDecimal price = product.price();
            int amount = orderedProducts.get(product);

            totalPrice1 = totalPrice1.add( price.multiply(new BigDecimal(amount)));

        }

        return new Order(this.orderId,this.orderedProducts,this.shippingAddress(),totalPrice1);
    }
}
