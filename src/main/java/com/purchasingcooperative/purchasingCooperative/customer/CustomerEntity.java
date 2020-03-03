package com.purchasingcooperative.purchasingCooperative.customer;


import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customers")
@SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "customer_id_seq", allocationSize = 1)
public class CustomerEntity {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
    @Column(name = "id")
    private long id;

    @Column(name = "email")
    private String email;

}
