package gr.codehub.advcart.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@MappedSuperclass
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    private String name;
    private LocalDate regDate;
    private String Email;

}
