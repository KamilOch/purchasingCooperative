package com.purchasingcooperative.purchasingCooperative.customer;

import com.purchasingcooperative.purchasingCooperative.supplier.SupplierEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "customers", collectionResourceRel = "customers")
public interface CustomersEntityRepository extends PagingAndSortingRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAll();

}
