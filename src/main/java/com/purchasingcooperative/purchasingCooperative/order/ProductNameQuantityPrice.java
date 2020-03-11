package com.purchasingcooperative.purchasingCooperative.order;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "productNameQuantityPrice")
@SequenceGenerator(name= "PNQP_SEQ", sequenceName = "pnqp_id_seq",allocationSize = 1)
public class ProductNameQuantityPrice {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PNQP_SEQ")
    @Column(name= "id")
    private long id;

    @Column(name= "productId")
    private long productId;

    @Column(name="productName")
    private String productName;

    @Column(name="productQuantity")
    private double productQuantity;

    @Column(name="productPricePerUnit")
    private BigDecimal productPricePerUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", insertable = false, updatable = false,nullable = false)
    private OrderEntity order;

    @NotNull
    @Column(name="order_id" ,unique = true)
    private long orderId;

}
