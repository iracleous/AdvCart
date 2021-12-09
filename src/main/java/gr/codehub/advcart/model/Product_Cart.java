package gr.codehub.advcart.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product_Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int quantity;
    private double discount;

    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;


}
