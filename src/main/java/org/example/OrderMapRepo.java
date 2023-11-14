package org.example;

import java.util.*;

public class OrderMapRepo implements OrderRepoInterface{
    private Map<String,Order> orderMap = new HashMap<>();
    @Override
    public void addOrder(Order order) {
        order = order.computeAndPlaceTotalPrice();
       orderMap.put(order.orderId(), order);
    }

    @Override
    public void removeOrder(Order order) {
        orderMap.remove(order.orderId());
    }

    @Override
    public List<Order> queryOrder(String query) {
        List<Order> queriedOrders = new ArrayList<>();
        orderMap.values()
                .stream()
                .filter(order -> order.shippingAddress().contains(query))
                .forEach(queriedOrders::add);
        return queriedOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMapRepo that = (OrderMapRepo) o;
        return Objects.equals(orderMap, that.orderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderMap);
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orderMap=" + orderMap +
                '}';
    }

    public Map<String, Order> getOrderMap() {
        return orderMap;
    }
}
