package gr.codehub.advcart.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private double price;


    @OneToMany(mappedBy = "product")
    private List<Product_Cart> carts;




}
