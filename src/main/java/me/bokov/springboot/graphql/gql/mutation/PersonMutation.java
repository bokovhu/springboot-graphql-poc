package me.bokov.springboot.graphql.gql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import me.bokov.springboot.graphql.data.entity.Address;
import me.bokov.springboot.graphql.data.entity.Person;
import me.bokov.springboot.graphql.data.repository.PersonRepository;
import me.bokov.springboot.graphql.gql.dto.PersonDTO;
import me.bokov.springboot.graphql.gql.dto.PersonInputDTO;
import me.bokov.springboot.graphql.gql.mapper.PersonToPersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PersonMutation implements GraphQLResolver <PersonMutation> {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonToPersonDTO personToPersonDTO;

    public PersonDTO getNew (PersonInputDTO person) {

        Person entity = new Person ();

        entity.setName (person.getName ());
        entity.setEmail (person.getEmail ());

        entity.setHomeAddress (new Address ());
        entity.getHomeAddress ().setCountry (person.getAddress ().getCountry ());
        entity.getHomeAddress ().setSettlement (person.getAddress ().getSettlement ());
        entity.getHomeAddress ().setStreetAddress (person.getAddress ().getStreetAddress ());

        entity = personRepository.saveAndFlush (entity);

        PersonDTO dto = new PersonDTO ();

        return personToPersonDTO.apply (entity);

    }

}
