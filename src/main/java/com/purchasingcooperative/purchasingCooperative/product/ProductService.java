package com.purchasingcooperative.purchasingCooperative.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductService {

    private final ProductsEntityRepository repository;

    @Autowired
    public ProductService(ProductsEntityRepository repository) {
        this.repository = repository;
    }

    public void addProduct(String name, ProductUnit unit) {
        ProductEntity newProduct = ProductEntity.builder().name(name).productUnit(unit).build();
        repository.save(newProduct);
    }

    public List<ProductEntity> getAllProducts() {
        return repository.findAll().stream().map(it -> ProductEntity.builder().id(it.getId()).name(it.getName()).productUnit(it.getProductUnit()).build()).collect(Collectors.toList());
    }

    public void deleteProduct(long id) {
        ProductEntity deletedProduct = findById(id);
        repository.delete(deletedProduct);
    }

    private ProductEntity findById(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
