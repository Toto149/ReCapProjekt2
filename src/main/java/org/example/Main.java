package org.example;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       Product product1 = new Product("Samsung Galaxy A53","Samsung",
               "Smartphones", new BigDecimal("399"));
       Product product2 = new Product("Samsung Galaxy A53","Samsung",
               "Smartphones",new BigDecimal("399"));
       Product product3 = new Product("LG Prisma 100","LG",
               "Fernseher",new BigDecimal("1299"));
       Product product4 = new Product("LG Prisma 100","LG",
               "Fernseher", new BigDecimal("1299"));
       Product product5 = new Product("Lamy Fountain 100","Lamy",
               "Füller", new BigDecimal("23.99"));

        Map<Product,Integer> products1 = new HashMap<>();
        products1.put(product1,3);
        products1.put(product2,5);
       Map<Product,Integer> products2 = new HashMap<>();
        products2.put(product3,1);
        products2.put(product4,1);
        Map<Product,Integer> products3 = new HashMap<>();
        products3.put(product1,3);
        products3.put(product2,5);
        products3.put(product4,1);
        products3.put(product5,3);

       Order order1 = new Order("123",products1,"Immermannstraße 20," +
               " Düsseldorf",new BigDecimal(0));
       Order order2 = new Order("356", products2, "Lolweg 53," +
               " Trollhausen",new BigDecimal(0));
       Order order3 = new Order("456", products3, "L," +
               " Trollhausen",new BigDecimal(0));
       order1.computeAndPlaceTotalPrice();
        System.out.println(order1.totalPrice());
        OrderListRepo orderListRepo = new OrderListRepo();
       orderListRepo.addOrder(order1);
       orderListRepo.addOrder(order2);

       ProductRepo productRepo = new ProductRepo();
       productRepo.addProduct(product1);
       productRepo.addProduct(product2);
       productRepo.addProduct(product3);
       productRepo.addProduct(product4);
       productRepo.addProduct(product5);

       ShopService amazon = new ShopService(productRepo,orderListRepo);
       amazon.placeOrder(order3);
        System.out.println(amazon.getOrderRepo());
    }
}