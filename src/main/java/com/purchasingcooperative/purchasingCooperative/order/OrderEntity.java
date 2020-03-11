package com.purchasingcooperative.purchasingCooperative.order;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "orders")
@SequenceGenerator(name= "ORDER_SEQ", sequenceName = "order_id_seq",allocationSize = 1)
public class OrderEntity {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    @Column(name= "id")
    private long id;

    @Column(name= "customer_id")
    private long customerId;

    @Column(name= "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<ProductNameQuantityPrice> productNameQuantityPrice;

}
