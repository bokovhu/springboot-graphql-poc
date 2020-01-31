package me.bokov.springboot.graphql.gql.mapper;

import me.bokov.springboot.graphql.data.entity.Animal;
import me.bokov.springboot.graphql.gql.dto.AnimalDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Component
@Transactional
public class AnimalToAnimalDTO implements Function<Animal, AnimalDTO> {

    @Override
    public AnimalDTO apply (Animal animal) {

        AnimalDTO dto = new AnimalDTO ();

        dto.setId (animal.getId ().toString ());
        dto.setName (animal.getName ());
        dto.setSpeciesId (animal.getSpecies ().getId ());
        dto.setOwnerId (animal.getOwner ().getId ());

        return dto;
    }

}
