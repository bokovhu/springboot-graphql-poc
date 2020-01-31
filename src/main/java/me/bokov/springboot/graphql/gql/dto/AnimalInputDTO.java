package me.bokov.springboot.graphql.gql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnimalInputDTO implements Serializable {

    private String name;
    private Long owner;
    private Long species;

}
