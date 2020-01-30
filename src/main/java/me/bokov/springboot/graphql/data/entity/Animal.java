package me.bokov.springboot.graphql.data.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@Data
public class Animal implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn
    private Species species;

    @ManyToOne (fetch = FetchType.LAZY, optional = true)
    @JoinColumn
    private Person owner;

    @NotBlank
    @Column (unique = true)
    private String name;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "animal")
    private Set <Vaccination> vaccinations;

    @ManyToMany
    @JoinTable
    private Set <Food> preferredFoods;

}
