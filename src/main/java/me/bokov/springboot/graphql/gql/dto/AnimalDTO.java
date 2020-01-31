package me.bokov.springboot.graphql.gql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnimalDTO implements Serializable {

    private String id;
    private String name;
    private Long ownerId;
    private Long speciesId;

}
