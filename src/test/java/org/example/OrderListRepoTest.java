package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {

    @Test
    void queryOrder_shouldReturnListOnlyComprisingOfOrder1_whenQueryIs123(){
        //GIVEN
        Product product1 = new Product("Lamy Füller", "Lamy","Füller",new BigDecimal("12.5"));
        Product product2 = new Product("LG 100", "LG","Fernseher",new BigDecimal("599"));
        Map<Product,Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(product1,1);
        List<Order> expected = new ArrayList<>();
        Order order1 = new Order("123", orderedProducts, "asdasdasd",new BigDecimal("12.5"));
        expected.add(order1);
        OrderListRepo orderListRepo = new OrderListRepo();
        orderListRepo.addOrder(order1);
        //WHEN
        List<Order> actual = orderListRepo.queryOrder("123");
        //THEN
        assertIterableEquals(expected,actual);
    }
    @Test
    void queryOrder_shouldReturnNull_whenQueryIs233(){
        //GIVEN
        Product product1 = new Product("Lamy Füller", "Lamy","Füller",new BigDecimal("12.5"));
        Product product2 = new Product("LG 100", "LG","Fernseher",new BigDecimal("599"));
        Map<Product,Integer> orderedProducts = new HashMap<>();
        orderedProducts.put(product1,1);
        List<Order> expected = new ArrayList<>();
        Order order1 = new Order("123", orderedProducts, "asdasdasd",new BigDecimal("12.5"));
        expected.add(order1);
        OrderListRepo orderListRepo = new OrderListRepo();
        orderListRepo.addOrder(order1);
        //WHEN
        List<Order> actual = orderListRepo.queryOrder("233");
        //THEN
        assertIterableEquals(expected,actual);
    }

}