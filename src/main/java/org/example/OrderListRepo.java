package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo implements OrderRepoInterface {
     private List<Order> orderList = new ArrayList<>();

    public  void addOrder(Order order){
        order = order.computeAndPlaceTotalPrice();
        orderList.add(order);
    }
    public  void removeOrder(Order order){
        orderList.remove(order);
    }
    public  List<Order> queryOrder(String query){
        List<Order> queriedOrders = new ArrayList<>();
        orderList.stream().filter(order -> order.orderId().contains(query)).forEach(queriedOrders::add);
        return queriedOrders;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orderList, that.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderList);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orderList=" + orderList +
                '}';
    }
}
