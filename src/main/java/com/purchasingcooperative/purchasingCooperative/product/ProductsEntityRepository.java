package com.purchasingcooperative.purchasingCooperative.product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "products", collectionResourceRel = "products")
public interface ProductsEntityRepository extends PagingAndSortingRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(long id);
}
