package com.purchasingcooperative.purchasingCooperative.basket;

import com.purchasingcooperative.purchasingCooperative.product.ProductEntity;
import com.purchasingcooperative.purchasingCooperative.product.ProductsEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
public class BasketService {

    private final Basket basket;
    private final ProductsEntityRepository productsRepository;

    @Autowired
    public BasketService(Basket basket, ProductsEntityRepository productsRepository) {
        this.basket = basket;
        this.productsRepository = productsRepository;
    }

    public void addToBasketProductAndQuantity(long productId, double quantity){
        ProductEntity productEntity = productsRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
        basket.addToBasketProductAndQuantity(productEntity, quantity);
    }

    public void removeFromBasketProduct(long productId){
        basket.removeFromBasketProduct(productId);
    }

    public void changeQuantity (long productId, double quantity){
        basket.changeQuantity(productId, quantity);
    }

    public Set<ProductAndQuantity> getBasketList(){
        return basket.getBasketList();
    }

    public BigDecimal basketSum(){
        return basket.basketSum();
    }

}
