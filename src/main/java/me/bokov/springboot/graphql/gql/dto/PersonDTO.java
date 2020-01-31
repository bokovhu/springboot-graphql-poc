package me.bokov.springboot.graphql.gql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {

    private String id;
    private String name;
    private String email;
    private AddressDTO address;

}
