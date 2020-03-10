package com.purchasingcooperative.purchasingCooperative.basket;

import com.purchasingcooperative.purchasingCooperative.product.ProductEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Basket {

    private List<ProductAndQuantity> basketList;

    public Basket() {
        basketList = new ArrayList<>();
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

    public List<ProductAndQuantity> getBasketList() {
        return new ArrayList<>(basketList);
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
