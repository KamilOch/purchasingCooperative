package com.purchasingcooperative.purchasingCooperative.basket;

import com.purchasingcooperative.purchasingCooperative.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ProductAndQuantity {

    private ProductEntity productEntity;
    private double quantity;
}
