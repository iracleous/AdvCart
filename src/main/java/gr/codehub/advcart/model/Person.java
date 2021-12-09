package gr.codehub.advcart.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@MappedSuperclass
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private LocalDate regDate;

    private int age;

    private String Email;
}
