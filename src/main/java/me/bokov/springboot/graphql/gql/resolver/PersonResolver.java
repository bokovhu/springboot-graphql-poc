package me.bokov.springboot.graphql.gql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import me.bokov.springboot.graphql.data.repository.AnimalRepository;
import me.bokov.springboot.graphql.data.repository.PersonRepository;
import me.bokov.springboot.graphql.gql.dto.AddressDTO;
import me.bokov.springboot.graphql.gql.dto.AnimalDTO;
import me.bokov.springboot.graphql.gql.dto.PersonDTO;
import me.bokov.springboot.graphql.gql.mapper.AnimalToAnimalDTO;
import me.bokov.springboot.graphql.gql.mapper.PersonToAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class PersonResolver implements GraphQLResolver<PersonDTO> {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AnimalToAnimalDTO animalToAnimalDTO;

    @Autowired
    private PersonToAddressDTO personToAddressDTO;

    public List<AnimalDTO> getPets (PersonDTO person) {

        return animalRepository.findAllByOwner_Id (
                Long.valueOf (person.getId ())
        ).stream ()
                .map (animalToAnimalDTO)
                .collect (Collectors.toList ());

    }

    public AddressDTO getAddress (PersonDTO person) {

        return personToAddressDTO.apply (
                personRepository.getOne (Long.valueOf (person.getId ()))
        );

    }

}
