package com.purchasingcooperative.purchasingCooperative.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "orders", collectionResourceRel = "orders")
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity, Long> {


}
