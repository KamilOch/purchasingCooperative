package com.purchasingcooperative.purchasingCooperative.customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "customers", collectionResourceRel = "customers")
public interface CustomersEntityRepository extends PagingAndSortingRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAll();

    Optional<CustomerEntity> findById(long id);

}
