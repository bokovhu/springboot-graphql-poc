package me.bokov.springboot.graphql.gql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpeciesInputDTO implements Serializable {

    private String name;
    private Long parent;

}
