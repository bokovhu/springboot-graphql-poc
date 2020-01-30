package me.bokov.springboot.graphql.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table
@Data
public class Species implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

}
