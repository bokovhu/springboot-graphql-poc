package me.bokov.springboot.graphql.data.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
@Data
public class Vaccination implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String type;

    @NotNull
    private LocalDate date;

    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn
    private Animal animal;

}
