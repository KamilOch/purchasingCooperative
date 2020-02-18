package com.purchasingcooperative.purchasingCooperative.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    private final ProductsEntityRepository repository;

    @Autowired
    public ProductService(ProductsEntityRepository repository) {
        this.repository = repository;
    }

    public void addProduct(String name, ProductUnit unit){
        ProductEntity newProduct = ProductEntity.builder().name(name).productUnit(unit).build();
        repository.save(newProduct);
    }
}
