package me.bokov.springboot.graphql.gql.mapper;

import me.bokov.springboot.graphql.data.entity.Person;
import me.bokov.springboot.graphql.gql.dto.PersonDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Component
@Transactional
public class PersonToPersonDTO implements Function <Person, PersonDTO> {

    @Override
    public PersonDTO apply (Person person) {

        PersonDTO dto = new PersonDTO ();

        dto.setId (person.getId ().toString ());
        dto.setName (person.getName ());
        dto.setEmail (person.getEmail ());

        return dto;
    }

}
