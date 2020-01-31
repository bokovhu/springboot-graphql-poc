package me.bokov.springboot.graphql.data.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Data
public class Species implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    @ManyToOne (fetch = FetchType.LAZY, optional = true)
    @JoinColumn
    private Species parentSpecies;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "parentSpecies")
    private List <Species> subSpecies;

}
