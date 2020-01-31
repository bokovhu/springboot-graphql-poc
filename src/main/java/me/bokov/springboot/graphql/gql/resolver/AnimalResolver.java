package me.bokov.springboot.graphql.gql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import me.bokov.springboot.graphql.data.repository.PersonRepository;
import me.bokov.springboot.graphql.data.repository.SpeciesRepository;
import me.bokov.springboot.graphql.gql.dto.AnimalDTO;
import me.bokov.springboot.graphql.gql.dto.PersonDTO;
import me.bokov.springboot.graphql.gql.dto.SpeciesDTO;
import me.bokov.springboot.graphql.gql.mapper.PersonToPersonDTO;
import me.bokov.springboot.graphql.gql.mapper.SpeciesToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AnimalResolver implements GraphQLResolver<AnimalDTO> {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private PersonToPersonDTO personToPersonDTO;

    @Autowired
    private SpeciesToDTO speciesToDTO;

    public PersonDTO getOwner (AnimalDTO animal) {

        return personToPersonDTO.apply (
                personRepository.getOne (animal.getOwnerId ())
        );

    }

    public SpeciesDTO getSpecies (AnimalDTO animal) {

        return speciesToDTO.apply (
                speciesRepository.getOne (animal.getSpeciesId ())
        );

    }

}
