package me.bokov.springboot.graphql.gql.mutation;

import com.coxautodev.graphql.tools.GraphQLResolver;
import me.bokov.springboot.graphql.data.entity.Animal;
import me.bokov.springboot.graphql.data.repository.AnimalRepository;
import me.bokov.springboot.graphql.data.repository.PersonRepository;
import me.bokov.springboot.graphql.data.repository.SpeciesRepository;
import me.bokov.springboot.graphql.gql.dto.AnimalDTO;
import me.bokov.springboot.graphql.gql.dto.AnimalInputDTO;
import me.bokov.springboot.graphql.gql.mapper.AnimalToAnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AnimalMutation implements GraphQLResolver <AnimalMutation> {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private AnimalToAnimalDTO animalToAnimalDTO;

    public AnimalDTO getNew (AnimalInputDTO animal) {

        Animal entity = new Animal ();

        entity.setName (animal.getName ());
        if (animal.getOwner () != null) {
            entity.setOwner (personRepository.getOne (animal.getOwner ()));
        }
        entity.setSpecies (speciesRepository.getOne (animal.getSpecies ()));

        entity = animalRepository.saveAndFlush (entity);

        return animalToAnimalDTO.apply (entity);

    }

}
