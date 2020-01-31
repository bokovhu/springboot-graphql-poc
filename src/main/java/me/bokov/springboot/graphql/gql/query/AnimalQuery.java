package me.bokov.springboot.graphql.gql.query;

import com.coxautodev.graphql.tools.GraphQLResolver;
import me.bokov.springboot.graphql.data.repository.AnimalRepository;
import me.bokov.springboot.graphql.gql.dto.AnimalDTO;
import me.bokov.springboot.graphql.gql.mapper.AnimalToAnimalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class AnimalQuery implements GraphQLResolver<AnimalQuery> {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalToAnimalDTO animalToAnimalDTO;

    public AnimalDTO getById (Long id) {
        return animalToAnimalDTO.apply (
                animalRepository.getOne (id)
        );
    }

    public List<AnimalDTO> getAll () {
        return animalRepository.findAll ()
                .stream ().map (animalToAnimalDTO)
                .collect (Collectors.toList ());
    }

}
