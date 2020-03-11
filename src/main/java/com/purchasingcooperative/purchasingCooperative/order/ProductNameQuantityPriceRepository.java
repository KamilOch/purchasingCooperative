package com.purchasingcooperative.purchasingCooperative.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="productNameQuantityPrice", collectionResourceRel = "productNameQuantityPrice")
public interface ProductNameQuantityPriceRepository extends PagingAndSortingRepository<ProductNameQuantityPrice, Long> {

}
