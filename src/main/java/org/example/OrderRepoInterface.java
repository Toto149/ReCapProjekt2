package org.example;

import java.util.List;

public interface OrderRepoInterface {
    public void addOrder(Order order);
    public void removeOrder(Order order);
    public List<Order> queryOrder(String query);
}
