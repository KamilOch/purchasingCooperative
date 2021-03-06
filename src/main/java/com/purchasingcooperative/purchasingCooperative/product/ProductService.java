package com.purchasingcooperative.purchasingCooperative.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductService {

    private final ProductsEntityRepository repository;

    @Autowired
    public ProductService(ProductsEntityRepository repository) {
        this.repository = repository;
    }

    public void addProduct(String name, ProductUnit unit, long supplierId, BigDecimal price) {
        ProductEntity newProduct = ProductEntity.builder()
                .name(name)
                .productUnit(unit)
                .supplierId(supplierId)
                .price(price)
                .build();
        repository.save(newProduct);
    }

    public List<ProductEntity> getAllProducts() {
        return repository.findAll().stream()
                .map(it -> ProductEntity.builder()
                        .id(it.getId())
                        .name(it.getName())
                        .price(it.getPrice())
                        .productUnit(it.getProductUnit())
                        .supplier(it.getSupplier())
                        .build())
                .collect(Collectors.toList());
    }

    public void deleteProduct(long id) {
        ProductEntity deletedProduct = findById(id);
        repository.delete(deletedProduct);
    }

    public ProductEntity findById(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void editProduct(long id, String name, ProductUnit productUnit) {
        ProductEntity editedProduct = findById(id);
        editedProduct.setName(name);
        editedProduct.setProductUnit(productUnit);
        repository.save(editedProduct);
    }
}
