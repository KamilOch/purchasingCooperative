package com.purchasingcooperative.purchasingCooperative.product;

import com.purchasingcooperative.purchasingCooperative.supplier.SupplierEntity;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "products")
@SequenceGenerator(name= "PRODUCT_SEQ", sequenceName = "product_id_seq",allocationSize = 1)
public class ProductEntity {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    @Column(name= "id")
    private long id;

    @Column(name= "name")
    private String name;

    @Column(name= "unit")
    @Enumerated(EnumType.STRING)
    private ProductUnit productUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false,nullable = false)
    private SupplierEntity supplier;

    @NotNull
    @Column(name="supplier_id" ,unique = true)
    private long supplierId;
}
