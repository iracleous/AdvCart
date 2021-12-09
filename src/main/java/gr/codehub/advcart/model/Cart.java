package gr.codehub.advcart.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date;


    @Transient
    private double cost;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<Product_Cart> products;


}
