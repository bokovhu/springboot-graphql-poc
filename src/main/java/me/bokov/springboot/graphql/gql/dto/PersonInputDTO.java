package me.bokov.springboot.graphql.gql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonInputDTO implements Serializable {

    private String name;
    private String email;
    private AddressInputDTO address;

}
