package com.purchasingcooperative.purchasingCooperative.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupplierService {

    private final SupplierEntityRepository repository;

    @Autowired
    public SupplierService(SupplierEntityRepository repository) {
        this.repository = repository;
    }

    public void addSupplier(String name) {
        SupplierEntity newSupplier = SupplierEntity.builder().name(name).build();
        repository.save(newSupplier);
    }
}
