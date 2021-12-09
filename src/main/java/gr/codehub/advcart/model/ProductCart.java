package gr.codehub.advcart.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int quantity;
    private double discount;

    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;


}
