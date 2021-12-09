package gr.codehub.advcart.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Employee  extends Person {



    @OneToMany(mappedBy = "employee")
private List<Customer> customers;
}
