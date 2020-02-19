package com.purchasingcooperative.purchasingCooperative.supplier;

import com.purchasingcooperative.purchasingCooperative.product.ProductEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "suppliers")
@SequenceGenerator(name = "SUPPLIER_SEQ", sequenceName = "supplier_id_seq", allocationSize = 1)
public class SupplierEntity {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPPLIER_SEQ")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<ProductEntity> products;
}
