package gr.codehub.advcart.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Table(name = "customer")
@Entity
public class Customer  extends Person{


    @OneToMany(mappedBy = "customer")
    private List<Cart> carts = new java.util.ArrayList<>();


    @ManyToOne
    private Employee employee;
}