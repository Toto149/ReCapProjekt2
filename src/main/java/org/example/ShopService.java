package org.example;

import java.util.Objects;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepoInterface orderRepo;

    public ShopService(){

    }

    public ShopService(ProductRepo productRepo, OrderRepoInterface orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(Order order){
        if(!productRepo.productList.contains(order.orderedProducts().keySet())){
            System.out.println("Eins der Objekte die bestellt wurden, sind nicht in dem ProductRepo vorhanden");
        }
        this.orderRepo.addOrder(order);
    }

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public OrderRepoInterface getOrderRepo() {
        return orderRepo;
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderRepo=" + orderRepo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderRepo, that.orderRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderRepo);
    }
}
