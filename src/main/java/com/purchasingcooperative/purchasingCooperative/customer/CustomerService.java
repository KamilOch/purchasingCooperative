package com.purchasingcooperative.purchasingCooperative.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerService {

private final CustomersEntityRepository repository;

    @Autowired
    public CustomerService(CustomersEntityRepository repository) {
        this.repository = repository;
    }

    public void addCustomer(String email){
        CustomerEntity newCustomer = CustomerEntity.builder()
                .email(email)
                .build();
        repository.save(newCustomer);
    }

    public List<CustomerEntity> getAllCustomers() {
        return repository.findAll()
                .stream()
                .map(it -> CustomerEntity.builder()
                        .id(it.getId())
                        .email(it.getEmail())
                        .build())
                .collect(Collectors.toList());
    }
}
