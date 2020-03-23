package com.purchasingcooperative.purchasingCooperative.order;

import com.purchasingcooperative.purchasingCooperative.basket.Basket;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderService {

    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }

    public void order(Basket basket, long customerId) {
        Set<ProductNameQuantityPrice> productNameQuantityPrice = basket.getBasketList()
                .stream()
                .map(it -> ProductNameQuantityPrice
                        .builder()
                        .productId(it.getProductEntity().getId())
                        .productName(it.getProductEntity().getName())
                        .productQuantity(it.getQuantity())
                        .productPricePerUnit(it.getProductEntity().getPrice())
                        .build())

                .collect(Collectors.toSet());

        OrderEntity newOrder = OrderEntity.builder().customerId(customerId).orderStatus(OrderStatus.RECEIVED).productNameQuantityPrice(productNameQuantityPrice).build();

        orderRepository.save(newOrder);
    }


}
