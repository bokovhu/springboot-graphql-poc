package me.bokov.springboot.graphql.data.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Data
public class Food implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    private boolean containsMeat;
    private boolean containsPlants;
    @NotNull
    private Double priceInEur;

    @ManyToMany
    @JoinTable
    private Set <Animal> preferredByAnimals;

}
