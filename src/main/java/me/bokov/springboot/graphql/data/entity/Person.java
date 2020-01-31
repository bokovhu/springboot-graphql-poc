package me.bokov.springboot.graphql.data.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Data
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    @Email
    @Column (unique = true)
    private String email;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "owner")
    private Set<Animal> pets;

    @Embedded
    private Address homeAddress;

}
