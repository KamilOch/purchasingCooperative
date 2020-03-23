package com.purchasingcooperative.purchasingCooperative.basket;

import com.purchasingcooperative.purchasingCooperative.product.ProductEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class Basket {

    private Set<ProductAndQuantity> basketList;

    public Basket() {
        basketList = new HashSet<>();
    }

    public void addToBasketProductAndQuantity(ProductEntity productEntity, double quantity) {
        boolean found = false;

        for (ProductAndQuantity productAndQuantity : basketList) {
            if (productAndQuantity.getProductEntity().getId() == productEntity.getId()) {
                productAndQuantity.setQuantity(productAndQuantity.getQuantity() + quantity);
                found = true;
                break;
            }
        }
        if (!found) {
            basketList.add(new ProductAndQuantity(productEntity, quantity));
        }
    }

    public void removeFromBasketProduct(long productId) {
        basketList.removeIf(product -> productId == product.getProductEntity().getId());
    }

    public void changeQuantity(long productId, double quantity) {
        for (ProductAndQuantity product : basketList
        ) {
            if (productId == product.getProductEntity().getId()) {
                product.setQuantity(quantity);
            }
        }
    }

    public Set<ProductAndQuantity> getBasketList() {
        return new HashSet<>(basketList);
    }

    public BigDecimal basketSum() {

        BigDecimal sum = new BigDecimal(0);
        for (ProductAndQuantity product : basketList) {

            BigDecimal price = product.getProductEntity().getPrice();
            double quantity = product.getQuantity();

            BigDecimal priceProductQuantityUnit = price.multiply(BigDecimal.valueOf(quantity));

            sum = sum.add(priceProductQuantityUnit);
        }
        return sum;
    }


}
