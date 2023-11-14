package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }
    public void remove(Product product){
        productList.remove(product);
    }
    public List<Product> queryProducts(String query){
        List<Product> queriedProducts = new ArrayList<>();
        productList.stream()
                .filter(product -> product.category().toLowerCase().contains(query.toLowerCase()))
                .forEach(queriedProducts::add);
        return queriedProducts;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productList);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "productList=" + productList +
                '}';
    }
}
