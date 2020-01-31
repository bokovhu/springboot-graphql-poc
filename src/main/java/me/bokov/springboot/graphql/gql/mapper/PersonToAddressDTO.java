package me.bokov.springboot.graphql.gql.mapper;

import me.bokov.springboot.graphql.data.entity.Address;
import me.bokov.springboot.graphql.data.entity.Person;
import me.bokov.springboot.graphql.gql.dto.AddressDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Component
@Transactional
public class PersonToAddressDTO implements Function<Person, AddressDTO> {

    @Override
    public AddressDTO apply (Person person) {

        Address address = person.getHomeAddress ();
        AddressDTO dto = new AddressDTO ();

        dto.setCountry (address.getCountry ());
        dto.setSettlement (address.getSettlement ());
        dto.setStreetAddress (address.getStreetAddress ());

        return dto;
    }

}
