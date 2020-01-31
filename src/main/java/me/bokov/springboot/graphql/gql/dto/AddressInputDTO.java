package me.bokov.springboot.graphql.gql.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressInputDTO implements Serializable {

    private String country;
    private String settlement;
    private String streetAddress;

}
