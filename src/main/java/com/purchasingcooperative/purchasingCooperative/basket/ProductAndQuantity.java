package com.purchasingcooperative.purchasingCooperative.basket;

import com.purchasingcooperative.purchasingCooperative.product.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ProductAndQuantity {

    private ProductEntity productEntity;
    private double quantity;

    public BigDecimal priceForOneProduct (){
        return getProductEntity().getPrice()
                .multiply(BigDecimal.valueOf(getQuantity()));
    }
}
