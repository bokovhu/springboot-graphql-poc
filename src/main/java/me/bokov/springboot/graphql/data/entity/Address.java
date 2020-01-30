package me.bokov.springboot.graphql.data.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class Address implements Serializable {

    private String country;
    private String settlement;
    private String streetAddress;

}
