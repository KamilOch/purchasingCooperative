package com.purchasingcooperative.purchasingCooperative.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<SupplierEntity> getAllSuppliers() {
        return repository.findAll().stream().map(it ->
                SupplierEntity.builder().id(it.getId()).name(it.getName()).products(it.getProducts()).build()).collect(Collectors.toList());
    }

    public SupplierEntity findById(long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void deleteSupplier(long id){
        SupplierEntity deletedSupplier = findById(id);
        repository.delete(deletedSupplier);
    }

    public void editSupplier(long id, String name) {
        SupplierEntity editedSupplier =findById(id);
        editedSupplier.setName(name);
        repository.save(editedSupplier);
    }
}
